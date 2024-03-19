package org.iesvdm;

import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class AlturaAlumnoTest {
    @Test
    void verdadero() {
        assertTrue(1==1);

    }
    /* aqui valido que se ha insertado el nombre en la última posicion, que todas las posiciones se mantienen, es decir,
    *  que el nuevo elemento se añade, no machaca información existente y */
    @Test
    void aniadenombreTest1(){
        final  String[] array=new String[10];
        array[0]="Jose";
        array[1]= "Paco";
        String nombre = "María";
        String [] arrayActual= AlturaAlumno.añadeNombre(array,nombre);
        assertTrue(arrayActual[arrayActual.length-1].equals(nombre));

        for (int i=0;i<array.length;i++){
            assertEquals(array[i], arrayActual[i]);
        }

        /*String [] arrayEspected = Arrays.copyOf(array, array.length+1);
        arrayEspected [arrayEspected.length-1]=nombre;
        assertEquals(arrayEspected, arrayActual);*/
    }
    /* aqui valido que se ha sumado correctamente el indice (longInicial+1) y que se corresponde con la longitud del array,
     *  tambien se validad que el ultimo nombre se ha añadido en la posicion inicial del array + 1 (longInicial+1) */
    @Test
    void aniadenombreTest2(){
        final  String[] array=new String[2];
        array[0]="Jose";
        array[1]= "Paco";
        int longInicial = array.length;
        String nombre = "María";
        String [] arrayActual= AlturaAlumno.añadeNombre(array,nombre);


        assertEquals(longInicial+1, arrayActual.length);
        assertEquals(nombre, arrayActual[longInicial+1]);
    }
    /* aqui valido que se realiza correctamente la inicializacion de la tabla de alturas, la longitud del array de nombres
    *  tiene que ser igual al de alturas y ademas, valido que todos los elementos de la tabla tengan el valor por defecto (1.5) */
    @Test
    void aniadeAturaTest1(){
        double alturaInicial=1.5;
        final  String[] array=new String[2];
        final  double[] arrayAl=new double[2];
        array[0]="Jose";
        array[1]= "Paco";
        String nombre="María";
        arrayAl[0]=1.5;
        arrayAl[1]=1.5;
        String [] arrayActual= AlturaAlumno.añadeNombre(array,nombre);
        double [] arrayAlAct = AlturaAlumno.añadeAltura(arrayAl);

        assertEquals(arrayActual.length, arrayAlAct.length);

        for (int i=0;i<arrayAlAct.length;i++){
            assertEquals(alturaInicial, arrayAlAct[i]);
        }

    }
    /* aqui voy a comprobar que no permite actualizar una posicion que no existe y que si exixte, la modifica correctamente */
    @Test
    void modificaAlturaTest(){
        double alturaNueva=1.78;
        int posicion=3;
        final  double[] arrayAl=new double[3];

        arrayAl[0]=1.5;
        arrayAl[1]=1.5;
        arrayAl[2]=1.5;
        //Estoy pasando indice 3 cuando solo hay 2
        AlturaAlumno.modificaAltura(arrayAl,posicion,alturaNueva);

        // la comprobacion de que no se ha realizado la actualizacion
        for (int i=0;i<arrayAl.length;i++){
            assertNotEquals(alturaNueva,arrayAl[i]);
        }

        double alturaNueva1=1.78;
        int posicion1=1;
        AlturaAlumno.modificaAltura(arrayAl,posicion1,alturaNueva1);

        assertEquals(arrayAl[posicion1],alturaNueva1);
    }
    /* */
    @Test
    void buscaNombreTest(){
        final  String[] array=new String[3];
        array[0]="Jose";
        array[1]= "Paco";
        array[2]="María";
        String nombre="María";
        int posicion=2;

        int indiceRetornado= AlturaAlumno.buscaNombre(array, nombre);

        assertEquals(posicion,indiceRetornado);

        nombre="Julio";
        posicion=-1;

        indiceRetornado= AlturaAlumno.buscaNombre(array, nombre);
        assertEquals(posicion,indiceRetornado);

    }
    @Test
    void mostrarTest(){
        //aqui pruebo que muestra por pantalla los datos correctamente
        final  String[] array=new String[3];
        array[0]="Jose";
        array[1]= "Paco";
        array[2]="María";
        final  double[] arrayAl=new double[3];
        arrayAl[0]=1.8;
        arrayAl[1]=1.65;
        arrayAl[2]=1.45;
        AlturaAlumno.mostrar(array, arrayAl);

        //aqui pruebo que muestra por pantalla los datos correctamente añadiendo un null al String ya que double no permite el null
        final  String[] array1=new String[3];
        array1[0]="Jose";
        array1[1]= null;
        array1[2]="María";
        final  double[] arrayAl1=new double[3];
        arrayAl1[0]=1.8;
        arrayAl1[1]=1.65;
        arrayAl1[2]=1.45;
        AlturaAlumno.mostrar(array1, arrayAl1);

        // aqui pruebo arrays vacios
        final  String[] array2=new String[1];
        final  double[] arrayAl2=new double[1];

        AlturaAlumno.mostrar(array2, arrayAl2);

    }
    /*hay que probar si devuelve el array vacio cuando le entra vacio y si devuelve el valor correcto */
    @Test
    void calculaMaximoTest(){
        //pruebo las posiciones mas conflictivas: la primera y la ultima
        double posicion=0.0;
        double valor=1.8;
        final  double[] arrayAl=new double[3];
        arrayAl[0]=1.8;
        arrayAl[1]=1.65;
        arrayAl[2]=1.45;
        double [] max=AlturaAlumno.calculaMaximo( arrayAl);

        assertEquals(posicion, max[0]);

        assertEquals(valor,max[1]);

        posicion=2.0;
        valor=1.95;
        final  double[] arrayAl1=new double[3];
        arrayAl1[0]=1.8;
        arrayAl1[1]=1.65;
        arrayAl1[2]=1.95;
        double [] max1=AlturaAlumno.calculaMaximo( arrayAl1);
        assertEquals(posicion, max1[0]);

        assertEquals(valor,max1[1]);

    // y ahora cualquier otra posicion
        posicion=2.0;
        valor=1.95;
        final  double[] arrayAl2=new double[4];
        arrayAl2[0]=1.8;
        arrayAl2[1]=1.65;
        arrayAl2[2]=1.95;
        arrayAl2[3]=1.65;
        double [] max2=AlturaAlumno.calculaMaximo( arrayAl2);
        assertEquals(posicion, max2[0]);

        assertEquals(valor,max2[1]);
        // y ahora compruebo que devuelve el array vacio cuando le entra uno vacio
        posicion=0.0;
        valor=0.0;
        final  double[] arrayAl3=new double[0];
        double [] max3=AlturaAlumno.calculaMaximo( arrayAl3);
        assertEquals(posicion, max3[0]);

        assertEquals(valor,max3[1]);
    }
    @Test
    void calculaMediaTest(){
        // hay que controlar que si el array entra vacio no divide por 0 y devuelve 0
        double resultado=0;
        final  double[] arrayAl=new double[0];
        double resuldev=AlturaAlumno.calculaMedia( arrayAl);
        assertEquals(resultado, resuldev);

        // ahora controlo que devuelve la media
        resultado=1.6333333333333335;
        final  double[] arrayAl1=new double[3];
        arrayAl1[0]=1.8;
        arrayAl1[1]=1.65;
        arrayAl1[2]=1.45;
        double resuldev1=AlturaAlumno.calculaMedia( arrayAl1);
        assertEquals(resultado, resuldev1);

    }

}
