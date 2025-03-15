import java.util.Scanner;

public class Principal {
    
    // Método para mostrar la información de un rectángulo
    public static void mostrarRectangulo(Rectangulo r) {
        System.out.println("Rectangulo = " + r.toString());
    }
    
    // Método para crear un rectángulo que representa el área de sobreposición
    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
        double xMin1 = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double xMax1 = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double yMin1 = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        double yMax1 = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        
        double xMin2 = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double xMax2 = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double yMin2 = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        double yMax2 = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        
        // Calcular las coordenadas del rectángulo de sobreposición
        double xMinSobre = Math.max(xMin1, xMin2);
        double xMaxSobre = Math.min(xMax1, xMax2);
        double yMinSobre = Math.max(yMin1, yMin2);
        double yMaxSobre = Math.min(yMax1, yMax2);
        
        // Crear y retornar el rectángulo de sobreposición
        Coordenada c1 = new Coordenada(xMinSobre, yMinSobre);
        Coordenada c2 = new Coordenada(xMaxSobre, yMaxSobre);
        return new Rectangulo(c1, c2);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Definir la capacidad del contenedor
        System.out.print("Ingrese la capacidad del contenedor de rectángulos: ");
        int capacidad = sc.nextInt();
        
        // Crear un contenedor de rectángulos
        ContainerRect contenedor = new ContainerRect(capacidad);
        
        boolean continuar = true;
        while(continuar) {
            // Crear un nuevo rectángulo
            System.out.print("Ingrese una esquina del rectángulo: \n");
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            System.out.print("Ingrese la esquina opuesta del rectángulo: \n");
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            
            Coordenada c1 = new Coordenada(x1, y1);
            Coordenada c2 = new Coordenada(x2, y2);
            Rectangulo rect = new Rectangulo(c1, c2);
            
            // Agregar el rectángulo al contenedor
            boolean agregado = contenedor.addRectagulo(rect);
            
            if (agregado) {
                System.out.println("Número de rectángulos agregados al contenedor: " + ContainerRect.getNumRec());
                System.out.println();
            } else {
                System.out.println("Contenedor lleno, ya no se pueden agregar más rectángulos.");
                continuar = false;
            }
        }
        
        // Mostrar el contenido del contenedor
        System.out.println("\nContenido del contenedor de rectángulos:");
        System.out.println(contenedor.toString());
        
        sc.close();
    }
}