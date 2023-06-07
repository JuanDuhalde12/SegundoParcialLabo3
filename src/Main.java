import models.Persona;
import models.SistemSalud;
import Exception.*;


public class Main {

   public static void main(String[] args){

      SistemSalud sistemSalud = new SistemSalud(3);
      Persona p1 = new Persona("Juan Duhalde","33","Zacagnini","5558215","empleado");
      Persona p2 = new Persona("Pedro Rodriguez","45","Roldan","3458695","abogado");
      Persona p3 = new Persona("Alberto Hernandez","60","Peralta Ramos","13267889","contador");
      Persona p4 = new Persona("Juan Perez","15","Zacagnini","5558215","empleado");
      Persona p5 = new Persona("Martin Valentinuzzi","23","Constitucion","39005123","estudiante");

     //agregando personas
      sistemSalud.agregarPersona(p1);
      sistemSalud.agregarPersona(p2);
      sistemSalud.agregarPersona(p3);
      sistemSalud.agregarPersona(p4);
      sistemSalud.agregarPersona(p5);

      //realizando tests
      sistemSalud.testear();



      sistemSalud.aislar();


      System.out.println("LISTA AISLADOS");
      sistemSalud.mostrarAislados();
      System.out.println("LISTA TESTEADOS");
      sistemSalud.mostrarTesteados();
      System.out.println("LISTA PERSONAS");
      sistemSalud.listarPersonas();


   }


}