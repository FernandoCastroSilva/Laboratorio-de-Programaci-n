//Alumno:Castro Silva,Fernando Abel
//codigo:18190090


package agenda;

import java.util.Scanner;

public class Agenda {	
	//Atributos
	Contacto[] lista;	

	//Metodos Constructores
	public Agenda(int tamanio_agenda){
		this.lista= new Contacto[tamanio_agenda]; 
	}
	private int contador_contactos = 0;
	public Agenda(){
		this.lista= new Contacto[10]; 
	}	

	//Metodos

	//Metodo insertar contactos
	public void setContacto(Contacto c){		
		int indice=buscar_indice_vacio();

		if(indice<0){
			System.out.println("");
			System.out.println("Importante: Agenda llena!");
		}else{
			this.lista[indice]=c;	
		}								
	}

	private int buscar_indice_vacio() {		
		int indice=0;		
		while(this.lista[indice]!=null){			
			indice++;
			if(indice > (this.lista).length-1){
				return -1;
			}				
		}		
		return indice;				
	}

	public void listarContactos(){
		System.out.println("");
		System.out.println("Lista de contactos");
		for(int i=0;i<(this.lista).length;i++){
			if(this.lista[i]==null){

			}else{
				System.out.println("");
				System.out.println("Contacto: "+(i+1));
				(this.lista[i]).DatosContacto();
			}
		}			
	}
	
	public void buscarPorNombre(String nombre) {
	boolean encontrado =false;
	for(int i=0;i<lista.length && !encontrado;i++) {
		if(lista[i]!=null && lista[i].getNombre().equalsIgnoreCase(nombre)) 
			System.out.println("Su nombre es " + lista[i].getNombre());
			System.out.println("Su email es "+lista[i].getEmail());
			System.out.println("Su email es "+lista[i].getTelefono());

		encontrado=true;
		}
	if(!encontrado) {
	System.out.println("No se ha encontrado el contacto");}
	}
	
	
	public void eliminarContacto(Agenda mi_agenda) {
		
		boolean encontrado=false;
		for(int i=0;i<lista.length && !encontrado;i++) {
			if(lista[i]!=null && lista[i].equals(mi_agenda)) {
				lista[i]=null;
				encontrado=true;
			}
		
		}
		
		if(encontrado) {
			System.out.println("Se ha eliminado el contacto");
		}
		else{
			System.out.println("No se ha eliminado contacto");
		}
		
	}
    public void ModificarContacto(Agenda mi_agenda) {
    	boolean encontrado = false;
    	 Scanner teclado = new Scanner(System.in);
         System.out.println("Nombre de contacto a modificar:");
         String eliminar = teclado.nextLine().toUpperCase();
         if (contador_contactos == 0) {
             System.out.println("No hay contactos");
         } else {
             for (int i = 0; i < this.contador_contactos; i++) {

                 if (eliminar.equals(this.lista[i].getNombre())) {
                     System.out.println(i + 1 + ". " + this.lista[i].getNombre() + "-" + "Tf:" + this.lista[i].getTelefono());
                     encontrado = true;
                 }
             }
             if (encontrado) {
                 System.out.println("¿Qué contacto quieres modificar?, introduce el número:");
                 int modificar_numero = Integer.parseInt(teclado.nextLine());

                 System.out.println("Introduce nombre:");
                 String nombre_nuevo = teclado.nextLine();
                 System.out.println("Introduce teléfono, formato numerico:");
                 int telefono_nuevo = Integer.parseInt(teclado.nextLine());

                 this.lista[modificar_numero - 1].setNombre(nombre_nuevo);
                 this.lista[modificar_numero - 1].setTelefono(Integer.toString(telefono_nuevo));
               
             } else {
                 System.out.println("No hay contactos con ese nombre");
             }

         }
     }
    	
    	
    }



