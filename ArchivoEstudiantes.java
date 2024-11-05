package archivoestudiantes;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class ArchivoEstudiantes {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Ingrese dos argumentos: número de estudiantes y la ruta del archivo.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        String ruta = args[1];
        TreeSet<Estudiante> estudiantes = new TreeSet<>();
        Scanner leer = new Scanner(System.in);
        
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese nombre: ");
            String nombre = leer.nextLine();
            
            System.out.println("Ingrese apellido: ");
            String apellido = leer.nextLine();
            
            System.out.println("Ingrese CI: ");
            int ci = leer.nextInt();
            leer.nextLine(); // Consumir la nueva línea después de nextInt
            
            System.out.println("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = null;

            try {
                fecha = df.parse(leer.nextLine());
            } catch (ParseException ex) {
                System.out.println("Formato de fecha incorrecto. Intente nuevamente: dd/MM/yyyy");
                i--; // Permite reingresar los datos para el mismo estudiante
                continue; // Salta a la siguiente iteración
            }

            estudiantes.add(new Estudiante(nombre, apellido, ci, fecha));
        }

        // Guardar el TreeSet en el archivo especificado
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta + "/resultado.ubi"))) {
            oos.writeObject(estudiantes); 
            System.out.println("Estudiantes guardados correctamente en: " + ruta + "/resultado.ubi");
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al guardar el archivo: " + ex.getMessage());
        }
    }
}
