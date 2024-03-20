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
        final  String[] array={"Jose","Paco"};

        String nombre = "María";
        String [] arrayActual= AlturaAlumno.añadeNombre(array,nombre);
        assertTrue(arrayActual[arrayActual.length-1].equals(nombre));

        for (int i=0;i<array.length;i++){
            assertEquals(array[i], arrayActual[i]);
        }
        //otra forma;
        /*String [] arrayEspected = Arrays.copyOf(array, array.length+1);
        arrayEspected [arrayEspected.length-1]=nombre;
        assertEquals(arrayEspected, arrayActual);*/
    }
    /* aqui valido que se ha sumado correctamente el indice (longInicial+1) y que se corresponde con la longitud del array,
     *  tambien se validad que el ultimo nombre se ha añadido en la posicion inicial del array + 1 (longInicial+1) */
    @Test
    void aniadenombreTest2(){
        final  String[] array={"Jose","Paco"};
        int longInicial = array.length;
        String nombre = "María";
        String [] arrayActual= AlturaAlumno.añadeNombre(array,nombre);


        assertEquals(longInicial+1, arrayActual.length);
        assertEquals(nombre, arrayActual[longInicial]);
    }
    /* aqui valido que se realiza correctamente la inicializacion de la tabla de alturas; la longitud del array de nombres
    *  tiene que ser igual al de alturas.*/
    @Test
    void aniadeAturaTest1(){
        double alturaInicial=1.5;
        final  String[] array={"Jose","Paco"};
        final  double[] arrayAl={1.5,1.5};
        String nombre="María";

        String [] arrayActual= AlturaAlumno.añadeNombre(array,nombre);
        double [] arrayAlAct = AlturaAlumno.añadeAltura(arrayAl);

        assertEquals(arrayActual.length, arrayAlAct.length);

        //Ademas, valido que todos los elementos de la tabla tengan el valor por defecto (1.5)

        for (int i=0;i<arrayAlAct.length;i++){
            assertEquals(alturaInicial, arrayAlAct[i]);
        }

    }
    /* aqui voy a comprobar que no permite actualizar una posicion que no existe y que si exixte, la modifica correctamente */
    @Test
    void modificaAlturaTest(){
        double alturaNueva=1.78;
        int posicion=3;
        final  double[] arrayAl={1.5, 1.5, 1.5};

        //Estoy pasando indice 3 y NO existe ya que va del 0 al 2
        AlturaAlumno.modificaAltura(arrayAl,posicion,alturaNueva);

        // la comprobacion de que no se ha realizado la actualizacion
        for (int i=0;i<arrayAl.length;i++){
            assertNotEquals(alturaNueva,arrayAl[i]);
        }
        //Esta SI existe y compruebo que la modifica
        double alturaNueva1=1.78;
        int posicion1=1;
        AlturaAlumno.modificaAltura(arrayAl,posicion1,alturaNueva1);

        assertEquals(arrayAl[posicion1],alturaNueva1);
    }
    /* Dejo todas las comprobaciones en un metodo Test para evitar tener que duplicar definicion de array  */
    @Test
    void buscaNombreTest(){
        final  String[] array={"Jose", "Paco", "María"};

        assertEquals(2,AlturaAlumno.buscaNombre(array, "María"));

    // EN ESTAS PRUEBAS QUE REALIZO A CONTINUACION, EL RESULTADO DE SALIDA ES EL MISMO (-1)
    // pruebo un elemento NULL

        assertEquals(-1,AlturaAlumno.buscaNombre(array, null));

    // pruebo elemento String vacio

        assertEquals(-1,AlturaAlumno.buscaNombre(array, ""));

    //Puebo un elemento inexistente
        assertEquals(-1,AlturaAlumno.buscaNombre(array, "julio"));
    }
    @Test
    void mostrarTestAFallo() {
        /* Comprueba que si no coinciden en la misma cantidad ambos arrays, ponemos el array de nombre con un occurs menos que
         * altura ya que en el proceso toma la longitud de nombre para hacer el proceso de mostrar pero nos da error si la longitud
         * del array del nombre es menor que la de la altura*/
        final String[] array = {"Jose", "Paco", "María"};

        final double[] arrayAl = {1.8, 1.45};

        assertThrows(ArrayIndexOutOfBoundsException.class,() -> {
            AlturaAlumno.mostrar(array, arrayAl);
        });

    }
    @Test
    void mostrarTest() {

        /*aqui pruebo que muestra por pantalla los datos correctamente añadiendo un null al String ya que double
         * no permite el null*/
        final String[] array1 = {"Jose", null, "María"};

        final double[] arrayAl1 = {1.8, 1.65, 1.45};

        assertDoesNotThrow(() -> AlturaAlumno.mostrar(array1, arrayAl1));
    }
    @Test
    void mostrarTestVacio(){
        /*aqui pruebo arrays vacios para comprobar que no devuelve nada, considero que se debia avisar al usuario con
        algun mensaje*/
        final String[] array2 ={};
        final double[] arrayAl2 ={};

        assertDoesNotThrow(() ->AlturaAlumno.mostrar(array2, arrayAl2));

    }


    @Test
    void calculaMaximoTest(){
        /* recordar que este metodo dado un array de alturas busca el maximo valor y devuelve en la
        *posicion [0] el indice en el que se encuentra y en la posicion [1] el valor maximo*/

        //pruebo las posiciones mas conflictivas: la primera y la ultima
        //Primera
        double posicion=0.0;
        double valor=1.8;
        final  double[] arrayAl={1.8,1.65,1.45};

        double [] max=AlturaAlumno.calculaMaximo( arrayAl);

        assertEquals(posicion, max[0]);

        assertEquals(valor,max[1]);
        // Ultima
        posicion=2.0;
        valor=1.95;
        final  double[] arrayAl1={1.8,1.65,1.95};

        double [] max1=AlturaAlumno.calculaMaximo( arrayAl1);
        assertEquals(posicion, max1[0]);

        assertEquals(valor,max1[1]);

    // y ahora cualquier otra posicion
        posicion=2.0;
        valor=1.95;
        final  double[] arrayAl2={1.8,1.65,1.95,1.65};

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
//Fin, ultima version
}
