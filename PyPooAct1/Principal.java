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
        
        // Crear el primer rectángulo
        System.out.print("Ingrese una esquina del 1er rectángulo: \n");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 1er rectángulo: \n");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        
        Coordenada c1A = new Coordenada(x1, y1);
        Coordenada c2A = new Coordenada(x2, y2);
        Rectangulo A = new Rectangulo(c1A, c2A);
        
        // Crear el segundo rectángulo
        System.out.print("Ingrese una esquina del 2do rectángulo: \n");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 2do rectángulo: \n");
        double x4 = sc.nextDouble();
        double y4 = sc.nextDouble();
        
        Coordenada c1B = new Coordenada(x3, y3);
        Coordenada c2B = new Coordenada(x4, y4);
        Rectangulo B = new Rectangulo(c1B, c2B);
        
        // Mostrar información de los rectángulos
        System.out.print("Rectangulo A = ");
        mostrarRectangulo(A);
        System.out.print("Rectangulo B = ");
        mostrarRectangulo(B);
        
        // Verificar la relación entre los rectángulos
        if (Verificador.seSobreponen(A, B)) {
            System.out.println("Rectangulos A y B se sobreponen.");
            Rectangulo sobreposicion = rectanguloSobre(A, B);
            double areaSobre = sobreposicion.calculoArea();
            System.out.printf("Area de sobreposicion = %.2f%n", areaSobre);
        } else if (Verificador.estanJuntos(A, B)) {
            System.out.println("Rectangulos A y B se juntan");
        } else if (Verificador.sonDisjuntos(A, B)) {
            System.out.println("Rectangulos A y B son disjuntos");
        }
        
        sc.close();
    }
}