public class Alumno extends Persona implements Informacion {


    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String genero ){
        super(nombre, apellidoPaterno, apellidoMaterno, edad, genero);
    }

    @Override
    public void mostrarInformacion() { // Cambio el nombre del método aquí también
        System.out.println("Alumno " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + " " + getEdad() + " " + getGenero());
    }
}