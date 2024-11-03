import java.util.Scanner;

public class TemperatureConverter {
    
    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Method to convert Celsius to Kelvin
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    // Method to convert Fahrenheit to Kelvin
    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5/9;
    }

    // Method to convert Kelvin to Celsius
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Method to convert Kelvin to Fahrenheit
    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin * 9/5) - 459.67;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Temperature Conversion Tool");
        System.out.println("1: Celsius to Fahrenheit");
        System.out.println("2: Celsius to Kelvin");
        System.out.println("3: Fahrenheit to Celsius");
        System.out.println("4: Fahrenheit to Kelvin");
        System.out.println("5: Kelvin to Celsius");
        System.out.println("6: Kelvin to Fahrenheit");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        System.out.print("Enter the temperature value to convert: ");
        double inputTemperature = scanner.nextDouble();
        double result = 0;

        switch (choice) {
            case 1:
                result = celsiusToFahrenheit(inputTemperature);
                System.out.println("Result: " + result + " °F");
                break;
            case 2:
                result = celsiusToKelvin(inputTemperature);
                System.out.println("Result: " + result + " K");
                break;
            case 3:
                result = fahrenheitToCelsius(inputTemperature);
                System.out.println("Result: " + result + " °C");
                break;
            case 4:
                result = fahrenheitToKelvin(inputTemperature);
                System.out.println("Result: " + result + " K");
                break;
            case 5:
                result = kelvinToCelsius(inputTemperature);
                System.out.println("Result: " + result + " °C");
                break;
            case 6:
                result = kelvinToFahrenheit(inputTemperature);
                System.out.println("Result: " + result + " °F");
                break;
            default:
                System.out.println("Invalid option selected.");
        }
        
        scanner.close();
    }
}
