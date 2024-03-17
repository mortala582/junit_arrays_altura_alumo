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

        AlturaAlumno.modificaAltura(arrayAl,posicion,alturaNueva);
        //System.out.println(Arrays.toString(arrayAl));

        // la comprobacion de que no se ha realizado la actualizacion
        for (int i=0;i<arrayAl.length;i++){
            assertNotEquals(alturaNueva,arrayAl[i]);
        }

        double alturaNueva1=1.78;
        int posicion1=1;
        AlturaAlumno.modificaAltura(arrayAl,posicion1,alturaNueva1);
        //System.out.println(Arrays.toString(arrayAl));

        assertEquals(arrayAl[posicion1],alturaNueva1);
    }
    /* */
    @Test
    void buscaNombreTest(){

    }


}
