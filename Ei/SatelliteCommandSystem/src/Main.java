import commands.ActivatePanelsCommand;
import commands.DeactivatePanelsCommand;
import commands.CollectDataCommand;
import commands.RotateCommand;
import invoker.SatelliteInvoker;
import satellite.Satellite;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Satellite satellite = new Satellite();
        SatelliteInvoker invoker = new SatelliteInvoker();
        Scanner scanner = new Scanner(System.in);
        
        boolean running = true;

        System.out.println("Welcome to the Satellite Command System");
        System.out.println("Satellite initialized with default state:");
        System.out.println(satellite.getState());

        while (running) {
            System.out.println("\nPlease choose a command: ");
            System.out.println("1: Rotate");
            System.out.println("2: Activate Panels");
            System.out.println("3: Deactivate Panels");
            System.out.println("4: Collect Data");
            System.out.println("5: View Satellite State");
            System.out.println("6: Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1: // Rotate
                    System.out.println("Enter direction to rotate (North, South, East, West): ");
                    String direction = scanner.nextLine();
                    invoker.executeCommand(new RotateCommand(satellite, direction));
                    break;
                
                case 2: // Activate Panels
                    invoker.executeCommand(new ActivatePanelsCommand(satellite));
                    break;
                    
                case 3: // Deactivate Panels
                    invoker.executeCommand(new DeactivatePanelsCommand(satellite));
                    break;
                    
                case 4: // Collect Data
                    invoker.executeCommand(new CollectDataCommand(satellite));
                    break;
                    
                case 5: // View State
                    System.out.println(satellite.getState());
                    break;
                    
                case 6: // Exit
                    running = false;
                    System.out.println("Exiting Satellite Command System...");
                    break;
                    
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
        
        scanner.close();
    }
}

