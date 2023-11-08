// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingresa una opción para la aplicación:\n1. Insertar nuevo Alumno\n2. Leer Alumnos\n3. Actualizar Alumno\n4. Eliminar Alumno");
            int menu = scanner.nextInt();

            switch(menu){
                case 1:
                    // Insertar
                    insertarNuevoAlumno();
                    break;
                case 2:
                    // Leer
                    leerTodosLosAlumnos();
                    break;
                case 3:
                    //actualizar
                    actualizarAlumno();
                    break;
                case 4:
                    //eliminar
                    eliminarAlumno();
                    break;
            }

        } catch(Exception e){
            System.out.println("Error" +e);
        } finally {
            scanner.close();
        }

    }

    public static void leerTodosLosAlumnos(){
        // Lectura de base de datos
        AlumnoDAO alumnoDao = new AlumnoDAO();
        List<Alumno> alumnos = alumnoDao.obtenerTodosLosAlumnos();

        for (Alumno alumno: alumnos){
            alumno.mostrarInformacion();
        }
    }

    public static void actualizarAlumno() {
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("Ingresa el ID del alumno");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingresa el nombre del Alumno:");
            String nombre = scanner.nextLine();

            System.out.println("Ingresa el apellido paterno");
            String apellidoPaterno = scanner.nextLine();

            System.out.println("Ingresa el apellido materno ");
            String apellidoMaterno = scanner.nextLine();

            System.out.println("Ingresa el genero del alumno");
            String genero = scanner.nextLine();

            System.out.println("Ingresa la edad del alumno");
            int edad = scanner.nextInt();

            Alumno alumno = new Alumno(id, nombre, apellidoPaterno, apellidoMaterno, edad, genero);
            alumno.setId(id);
            alumno.setNombre(nombre);
            alumno.setApellidoPaterno(apellidoPaterno);
            alumno.setApellidoMaterno(apellidoMaterno);
            alumno.setEdad(edad);
            alumno.setGenero(genero);

            // Actualización en base de datos
            AlumnoDAO alumnoDao = new AlumnoDAO();
            alumnoDao.actualizarAlumno(alumno);

        } catch(Exception e){
            System.out.println("Error" +e);
        }
        finally{
            scanner.close();
        }
    }

    public static void eliminarAlumno(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingresa el ID del Alumno a eliminar:");
            int id = scanner.nextInt();


            // Eliminación en base de datos
            AlumnoDAO alumnoDao = new AlumnoDAO();
            alumnoDao.eliminarAlumnnoPorId(id);

        } catch(Exception e){
            System.out.println("Error" +e);
        }
        finally{
            scanner.close();
        }
    };

    public static void insertarNuevoAlumno() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingresa el nombre del Alumno:");
            String nombre = scanner.nextLine();

            System.out.println("Ingresa el apellido paterno");
            String apellidoPaterno = scanner.nextLine();

            System.out.println("Ingresa el apellido materno ");
            String apellidoMaterno = scanner.nextLine();

            System.out.println("Ingresa el genero del alumno");
            String genero = scanner.nextLine();

            System.out.println("Ingresa la edad del alumno");
            int edad = scanner.nextInt();

            Alumno alumno = new Alumno(0, nombre, apellidoPaterno, apellidoMaterno, edad, genero);
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