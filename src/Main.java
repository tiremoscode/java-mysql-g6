// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingressa el nombre del Alumno:");
            String nombre = scanner.nextLine();

            System.out.println("Ingresa el apellido paterno");
            String apellidoPaterno = scanner.nextLine();

            System.out.println("Ingresa el apellido materno ");
            String apellidoMaterno = scanner.nextLine();

            System.out.println("Ingresa el genero del alumno");
            String genero = scanner.nextLine();

            System.out.println("Ingresa la edad del alumno");
            int edad = scanner.nextInt();

            Alumno alumno = new Alumno(nombre, apellidoPaterno, apellidoMaterno, edad, genero);
            alumno.setNombre(nombre);
            alumno.setApellidoPaterno(apellidoPaterno);
            alumno.setApellidoMaterno(apellidoMaterno);
            alumno.setEdad(edad);
            alumno.setGenero(genero);

            alumno.mostrarInformacion();

            // Inserción en base de datos
            AlumnoDAO alumnoDao = new AlumnoDAO();
            alumnoDao.insertarAlumno(alumno);

        } catch(Exception e){
            System.out.println("Error" +e);
        }
        finally{
            scanner.close();
        }
    }



}