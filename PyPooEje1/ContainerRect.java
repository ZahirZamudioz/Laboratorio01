
public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;
    private static int numRec = 0;
    
    // Constructor
    public ContainerRect(int capacidad) {
        this.n = capacidad;
        this.rectangulos = new Rectangulo[n];
        this.distancias = new double[n];
        this.areas = new double[n];
    }

    public static int getNumRec() {
        return numRec;
    }

    // Método para agregar un rectángulo al contenedor
    public boolean addRectagulo(Rectangulo rec) {
        if (numRec < n) {
            rectangulos[numRec] = rec;
            
            // Calcular la distancia euclidiana entre las esquinas del rectángulo
            distancias[numRec] = rec.getEsquina1().distancia(rec.getEsquina2());
            
            // Calcular el área del rectángulo
            areas[numRec] = rec.calculoArea();
            
            numRec++;
            return true;
        } else {
            return false;
        }
    }
    
    // Método para obtener una representación en cadena del contenedor
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("%-12s%-30s%-12s%-12s\n", "Rectangulo", "Coordenadas", "Distancia", "Area"));
        
        for (int i = 0; i < numRec; i++) {
            sb.append(String.format("%-12d%-30s%-12.3f%-12.2f\n", 
                (i+1), 
                rectangulos[i].toString(), 
                distancias[i], 
                areas[i]));
        }
        
        return sb.toString();
    }
}