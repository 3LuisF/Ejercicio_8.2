package Notas;
// aqui se hace un array de tipo double
public class Notas {
    double[] listaNotas; // array vacio
    // ahora el constructor
    public Notas() {
        listaNotas = new double[5]; // Crea un array de 5 notas
    }
    //metodo para el promedio
    double calcularPromedio(){
        double suma = 0;
        for( int i=0; i<listaNotas.length;i++){
            suma += listaNotas[i]; // ciclo for para sumar notas
        }
        return (suma/listaNotas.length); //retorna promedio
    }
    //metodo constructor para la desviacion estandar
    double calcularDesviacion(){
        double promedio = calcularPromedio(); //llamar a promedio
        double suma = 0; //acumulador para la desviacion
        for(int i =0; i<listaNotas.length;i++){
            suma+= Math.pow(listaNotas[i]-promedio,2); // aplicar formula de la varianza
        }
        return Math.sqrt(suma/listaNotas.length); // encontrar desviacion estandar
    }
    //metodo constructor para encontrar la menor nota
    double calcularMenor(){
        double menor = listaNotas[0];
        for(int i=0;i<listaNotas.length;i++){
            if(listaNotas[i]<menor){
                menor = listaNotas[i];
            }
        }
        return menor;
    }
    //metodo constructor para encontrar el mayor
    double calcularMayor(){
        double mayor = listaNotas[0];
        for(int i=0;i<listaNotas.length;i++){
            if(listaNotas[i]>mayor){
                mayor = listaNotas[i];
            }
        }
        return mayor;
    }


}
