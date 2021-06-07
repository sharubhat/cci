package threads_book.thread_groups_cyclic_barrier;


import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by sharath on 11/15/16.
 */
public class Main {
    public static void main(String[] args) {
        String cid1 = "31000000";
        String cid2 = "59000000";
        ThreadGroup tg1 = new ThreadGroup(cid1);
        ThreadGroup tg2 = getThreadGroup(cid1);
        System.out.println("Current group is " + tg2.getName());

        Thread t1 = new Thread(tg1, new Worker(cid1), "cid1-Worker");
        Thread t2 = new Thread(tg1, new Worker(cid2), "cid2-Worker");
        Random r = new Random();
        t1.start();
        try {
            int n = r.nextInt(10);
            System.out.println(n);
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(getThreadGroup(cid1) != null) {

        }
        t2.start();
    }

    static ThreadGroup rootThreadGroup = null;

    static ThreadGroup getRootThreadGroup( ) {
        if ( rootThreadGroup != null )
            return rootThreadGroup;
        ThreadGroup tg = Thread.currentThread( ).getThreadGroup( );
        ThreadGroup ptg;
        while ( (ptg = tg.getParent( )) != null )
            tg = ptg;
        return tg;
    }

    static ThreadGroup[] getAllThreadGroups( ) {
        final ThreadGroup root = getRootThreadGroup( );
        int nAlloc = root.activeGroupCount( );
        int n = 0;
        ThreadGroup[] groups;
        do {
            nAlloc *= 2;
            groups = new ThreadGroup[ nAlloc ];
            n = root.enumerate( groups, true );
        } while ( n == nAlloc );

        ThreadGroup[] allGroups = new ThreadGroup[n+1];
        allGroups[0] = root;
        System.arraycopy( groups, 0, allGroups, 1, n );
        return allGroups;
    }

    static ThreadGroup getThreadGroup( final String name ) {
        if ( name == null )
            throw new NullPointerException( "Null name" );
        final ThreadGroup[] groups = getAllThreadGroups( );
        for ( ThreadGroup group : groups )
            if ( group.getName( ).equals( name ) )
                return group;
        return null;
    }

    static class Worker implements Runnable {
        String clientId;

        public Worker(String clientId) {
            this.clientId = clientId;
        }

        @Override
        public void run() {
            System.out.println("Current thread count " + Thread.currentThread().getThreadGroup().activeCount());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(Thread.currentThread().getThreadGroup().activeCount() < 2) {
                System.out.println("Proceeding");
            }
            System.out.println("Inside thread : " + Thread.currentThread().getName() +
            " client id = " + clientId);
        }
    }
}
