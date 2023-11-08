public class Alumno extends Persona implements Informacion {


    public Alumno(int id, String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String genero ){
        super(id, nombre, apellidoPaterno, apellidoMaterno, edad, genero);
    }

    @Override
    public void mostrarInformacion() { // Cambio el nombre del método aquí también
        System.out.println("Alumn@ " + getId() + " " + getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() + " " + getEdad() + " " + getGenero());
    }
}