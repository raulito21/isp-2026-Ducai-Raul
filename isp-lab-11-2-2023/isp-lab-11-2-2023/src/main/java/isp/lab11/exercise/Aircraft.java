package isp.lab11.exercise;

import java.util.Objects;

public class Aircraft implements Runnable {
    private final String id;
    private int altitude;
    private State state;
    private final Object lock;
    private int assignedAltitude;

    public Aircraft(String id)
    {
        this.id=id;
        this.altitude=0;
        this.state=State.ON_STAND;
        this.lock=new Object();
        this.assignedAltitude=0;
        System.out.println("Aircraft "+id+" is created. Ready to take off. State:"+state);
    }

    public void receiveATCCommand(AtcCommand atcCommand)
    {
        if(atcCommand instanceof TakeoffCommand && this.state==State.ON_STAND)
        {
            takeOff();
        }
        else if(atcCommand instanceof LandCommand)
        {
            land();
        }
    }


    private void takeOff()
    {
        synchronized (lock)
        {
            this.notify();
        }
    }

    private void land()
    {
        if(this.state==State.CRUISING){
            synchronized (lock)
            {
                this.notify();
            }
        }
        else System.out.println("Aircraft"+id+" is ready to land");
    }

    public State getState()
    {
        return state;
    }

    @Override
    public void run() {
        System.out.println("Aircraft"+id+" is waiting for takeoff_CMD");
        synchronized (lock){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.state=State.TAXIING;
        System.out.println("Aircraft"+id+" is taxiing");
        try
        {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        this.state=State.TAKING_OFF;
        System.out.println("Aircraft"+id+" is taking off");
        try
        {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.state=State.ASCENDING;
        System.out.println("Aircraft"+id+" is ascending");
        try
        {
            while(this.altitude<this.assignedAltitude)
            {
                    Thread.sleep(10000);

                this.altitude+=1000;
                System.out.println("Aircraft"+id+" is ascending. Current altitude"+ this.altitude);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.state=State.CRUISING;
        System.out.println("Aircraft"+id+" is cruising. Current altitude"+ this.altitude);
        synchronized (lock) {
            try {
                System.out.println("Aircraft"+id+" is waiting for LAND_CMD");
                this.wait(); /// wait for land command
                System.out.println("Aircraft"+id+" received LAND_CMD");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /// TODO: Implement descending,landed states as well cu print
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Aircraft aircraft)) return false;
        return Objects.equals(id, aircraft.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id='" + id + '\'' +
                ", state=" + state +
                ", altitude=" + altitude +
                ", assignedAltitude=" + assignedAltitude +
                '}'+ "\n";
    }
}
