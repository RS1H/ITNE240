import java.io.*;
import java.util.concurrent.*;

// producer thread
class Prod extends Thread {
    private PipedOutputStream out;
    String[] msgs = {"i", "love", "itne", "240"};
    public Prod(PipedOutputStream out) {
        this.out = out;
    }
    public void run() {
        try {
            for (String m : msgs) {
                out.write((m + "\n").getBytes());
                out.flush();
                System.out.println("prod: " + m);
                Thread.sleep(1500); // delay
            }
            out.close();
        } catch (Exception e) {
            //ignore it
        }
    }
}

// consumer thread
class Cons extends Thread {
    private PipedInputStream in;
    public Cons(PipedInputStream in) {
        this.in = in;
    }
    public void run() {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            String l;
            while ((l = r.readLine()) != null) {
                System.out.println("cons got: " + l.toUpperCase());
            }
            r.close();
        } catch (Exception e) {
            // TODO: handle error
        }
    }
}

// queue producer
class QProd extends Thread {
    private BlockingQueue<String> q;
    String[] msgs = {"network", "operating", "system", "project"};
    public QProd(BlockingQueue<String> q) {
        this.q = q;
    }
    public void run() {
        for (String m : msgs) {
            try {
                q.put(m);
                System.out.println("QProd: " + m);
                Thread.sleep(2000);
            } catch (Exception e) {
                //s
            }
        }
    }
}

//queue consumer
class QCons extends Thread {
    private BlockingQueue<String> q;
    public QCons(BlockingQueue<String> q) {
        this.q = q;
    }
    public void run() {
        while (true) {
            try {
                String m = q.take();
                System.out.println("QCons got: " + m.toUpperCase());
                if (m.equals("end")) break;
            } catch (Exception e) {
                
            }
        }
    }
}