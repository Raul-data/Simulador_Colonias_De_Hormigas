public class HormigaObrera extends Hormiga {
    //Creamos el constructor,que recibe el id y la poscion donde nace la obreara
    //0(1)
    public HormigaObrera(String id,Posicion posicionInicial){
        super(id, TipoHormiga.OBRERA, posicionInicial); // de esta manera hacemos la llamada al constructor padre
    }

    //Metodo run vacio
    @Override
    public void run(){
        //por ahora no le metemos nada son hilos
    }

}
