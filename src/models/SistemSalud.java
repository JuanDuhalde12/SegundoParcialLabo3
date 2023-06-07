package models;


import java.util.*;

import Exception.*;

public class SistemSalud {
    private Set<Persona> listaPersonas;
    private Set<Registro> listaTesteados;
    private Map<Integer,Registro> listaAislados;
    private int cantReactivos;


    public SistemSalud() {
    }

    public SistemSalud(int cantReactivos) {
        this.listaPersonas = new LinkedHashSet<Persona>();
        this.listaTesteados = new LinkedHashSet<Registro>();
        this.listaAislados = new HashMap<Integer,Registro>();
        this.cantReactivos = cantReactivos;
    }

    public int getCantReactivos() {
        return cantReactivos;
    }

    public void setCantReactivos(int cantReactivos) {
        this.cantReactivos = cantReactivos;
    }

    public void agregarPersona(Persona p) {
        try{
            boolean flag = buscarSiExiste(p.getDNI());
            if(!flag){
                this.listaPersonas.add(p);
            }
        }catch(PersonaExiste e){
            System.out.println("ERROR DNI EXISTENTE: "+e.getMessage());
        }
    }

    public boolean buscarSiExiste(String Dni) throws PersonaExiste{
        boolean flag = false;
        for(Persona persona : this.listaPersonas){
            if(persona.getDNI().equals(Dni)){
                throw new PersonaExiste("La persona con DNI: "+persona.getDNI()+", ya existe con el nombre: "+persona.getNombre());
            }
        }
        return flag;
    }

    public void testear() {
        for(Persona p:this.listaPersonas){
            int temperatura = (int)(Math.random()*(39 - 36 + 1) + 36);
            Registro registro = new Registro(p.getDNI(),temperatura);
            this.listaTesteados.add(registro);
            try {
                quitarReactivo();

            }catch(ReactivoException e2){
                System.out.println("ERROR REACTIVO: "+e2.getMessage());
            }
        }
    }

    public void quitarReactivo() throws ReactivoException{
        if(this.cantReactivos!=0) {
            this.cantReactivos--;
        }else {
            this.setCantReactivos(10);
            throw new ReactivoException("Reactivo agotado agregando 10 reactivos mas...");
        }
    }
    public void aislar(){
        for(Registro r:this.listaTesteados){
            if(r.getTemperatura() >= 38) {
                Persona buscado = buscarPersona(r.getDni());
                if(buscado != null){try{
                    this.aislarPersona(buscado,r);
                }catch(AislarException e1){
                    System.out.println("ALERTA AISLAR PERSONA: "+e1.getMessage());
                }
                }
            }
        }

    }

    public void aislarPersona(Persona buscado, Registro r) throws AislarException {
        this.listaAislados.put(r.getNumeroTest(), r);
        throw new AislarException("Persona aislada ", buscado.getBarrio(), r.getNumeroTest());
    }

    public Persona buscarPersona(String Dni){
        Persona buscado = null;
        for(Persona persona : this.listaPersonas){
            if(persona.getDNI().equals(Dni)){
                buscado = persona;
            }
        }
        return buscado;
    }
    public void mostrarTesteados(){
        for (Registro r:this.listaTesteados) {
            System.out.println(r.toString());
        }
    }

    public void listarPersonas(){
        for (Persona r:this.listaPersonas) {
            System.out.println(r.toString());
        }
    }

    public void mostrarAislados(){
        for(Map.Entry<Integer, Registro> entry : this.listaAislados.entrySet()){
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
        }
    }
}
