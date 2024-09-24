package cn;
import java.util.Random;
public class experiment4a {
	public static void main(String[] args) {
        int packetsToSend = 2; 
        int packetsSent = 0;  
        int packetsReceived = 0; 
        int minTime = 20;   
        int maxTime = 100;     
        Random random = new Random();

        System.out.println("Starting Ping Simulation:");
        for (int i = 1; i <= packetsToSend; i++) {
            int time = random.nextInt(maxTime - minTime + 1) + minTime;
            packetsSent++;
            
            System.out.println("Packet " + i + " sent, Time: " + time + "ms");
            boolean isReceived = random.nextBoolean(); 
            if (isReceived) {
                packetsReceived++;
                System.out.println("Packet " + i + " received.");
            } else {
                System.out.println("Packet " + i + " lost.");
            }

            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nPing simulation completed.");
        System.out.println("Packets sent: " + packetsSent);
        System.out.println("Packets received: " + packetsReceived);
        System.out.println("Packets lost: " + (packetsSent - packetsReceived));
    }
}
