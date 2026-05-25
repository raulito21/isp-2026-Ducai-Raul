package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoorLockController implements ControllerInterface {
    private Map<Tenant, AccessKey> validAccess;
    private List<AccessLog> accessLogs;
    private Door door;
    private int failedAttempts;

    public DoorLockController() {
        this.validAccess = new HashMap<>();
        this.accessLogs = new ArrayList<>();
        this.door = new Door();
        this.failedAttempts = 0;
    }

    @Override
    public DoorStatus enterPin(String pin) throws Exception {
        if (pin.equals(ControllerInterface.MASTER_KEY)) {
            failedAttempts = 0;
            door.unlockDoor();
            logAccess(ControllerInterface.MASTER_TENANT_NAME, "enterPin", door.getStatus(), null);
            return door.getStatus();
        }

        if (failedAttempts >= 3) {
            logAccess("Unknown", "enterPin", door.getStatus(), "TooManyAttemptsException");
            throw new TooManyAttemptsException("Too many attempts");
        }

        Tenant foundTenant = null;
        for (Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
            if (entry.getValue().getPin().equals(pin)) {
                foundTenant = entry.getKey();
                break;
            }
        }

        if (foundTenant == null) {
            failedAttempts++;
            if (failedAttempts >= 3) {
                logAccess("Unknown", "enterPin", door.getStatus(), "TooManyAttemptsException");
                throw new TooManyAttemptsException("Too many attempts");
            }
            logAccess("Unknown", "enterPin", door.getStatus(), "InvalidPinException");
            throw new InvalidPinException("Invalid pin");
        }

        failedAttempts = 0;
        if (door.getStatus() == DoorStatus.OPEN) {
            door.lockDoor();
        } else {
            door.unlockDoor();
        }

        logAccess(foundTenant.getName(), "enterPin", door.getStatus(), null);
        return door.getStatus();
    }

    @Override
    public void addTenant(String pin, String name) throws Exception {
        Tenant tenant = new Tenant(name);
        if (validAccess.containsKey(tenant)) {
            logAccess(name, "addTenant", door.getStatus(), "TenantAlreadyExistsException");
            throw new TenantAlreadyExistsException("Tenant already exists");
        }
        validAccess.put(tenant, new AccessKey(pin));
        logAccess(name, "addTenant", door.getStatus(), null);
    }

    @Override
    public void removeTenant(String name) throws Exception {
        Tenant tenant = new Tenant(name);
        if (!validAccess.containsKey(tenant)) {
            logAccess(name, "removeTenant", door.getStatus(), "TenantNotFoundException");
            throw new TenantNotFoundException("Tenant not found");
        }
        validAccess.remove(tenant);
        logAccess(name, "removeTenant", door.getStatus(), null);
    }

    public List<AccessLog> getAccessLogs() {
        return accessLogs;
    }

    private void logAccess(String tenantName, String operation, DoorStatus doorStatus, String errorMessage) {
        AccessLog log = new AccessLog(tenantName, LocalDateTime.now(), operation, doorStatus, errorMessage);
        accessLogs.add(log);
    }
}