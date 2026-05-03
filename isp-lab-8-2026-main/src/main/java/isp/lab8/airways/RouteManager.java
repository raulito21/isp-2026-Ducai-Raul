package isp.lab8.airways;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RouteManager {
    private String baseDirectory;

    public RouteManager(String baseDirectory) {
        this.baseDirectory = baseDirectory;
        new File(this.baseDirectory).mkdirs();
    public void createRoute(String routeName) {
        File routeFolder = new File(baseDirectory, routeName);
        if (!routeFolder.exists()) {
            routeFolder.mkdirs();
            System.out.println("Ruta '" + routeName + "' a fost creata.");
        } else {
            System.out.println("Ruta '" + routeName + "' exista deja.");
        }
    }
    public void addWaypoint(String routeName, Waypoint waypoint) {
        File routeFolder = new File(baseDirectory, routeName);
        if (!routeFolder.exists()) {
            System.out.println("Eroare: Ruta nu exista.");
            return;
        }

        File waypointFile = new File(routeFolder, waypoint.getName() + ".dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(waypointFile))) {
            oos.writeObject(waypoint);
        } catch (IOException e) {
            System.out.println("Eroare la salvarea waypoint-ului: " + e.getMessage());
        }
    }
    public List<Waypoint> loadRoute(String routeName) {
        List<Waypoint> waypoints = new ArrayList<>();
        File routeFolder = new File(baseDirectory, routeName);

        if (routeFolder.exists() && routeFolder.isDirectory()) {
            File[] files = routeFolder.listFiles();
            if (files != null) {
                for (File file : files) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        Waypoint wp = (Waypoint) ois.readObject();
                        waypoints.add(wp);
                    } catch (Exception e) {
                        System.out.println("Eroare la citirea fișierului: " + e.getMessage());
                    }
                }
            }
        }
        waypoints.sort(Comparator.comparingInt(Waypoint::getIndex));
        return waypoints;
    }
    public double calculateTotalDistance(List<Waypoint> waypoints) {
        double totalDistance = 0;
        for (int i = 0; i < waypoints.size() - 1; i++) {
            Waypoint w1 = waypoints.get(i);
            Waypoint w2 = waypoints.get(i + 1);
            totalDistance += WaypointDistanceCalculator.calculateDistance(
                    w1.getLatitude(), w1.getLongitude(), 
                    w2.getLatitude(), w2.getLongitude()
            );
        }
        return totalDistance;
    }
    public void listAvailableRoutes() {
        File baseFolder = new File(baseDirectory);
        String[] routes = baseFolder.list((current, name) -> new File(current, name).isDirectory());
        System.out.println("Rute disponibile: " + (routes != null ? Arrays.toString(routes) : "Nicio rută"));
    }
    public void deleteRoute(String routeName) {
        File routeFolder = new File(baseDirectory, routeName);
        if (routeFolder.exists()) {
            File[] files = routeFolder.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
            routeFolder.delete();
            System.out.println("Ruta '" + routeName + "' a fost stearsa cu succes.");
        }
    }
}