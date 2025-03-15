
public class Verificador {
    
    // Método para verificar si dos rectángulos se sobreponen
    public static boolean seSobreponen(Rectangulo r1, Rectangulo r2) {
        double xMin1 = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double xMax1 = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double yMin1 = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        double yMax1 = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        
        double xMin2 = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double xMax2 = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double yMin2 = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        double yMax2 = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        
        return (xMin1 < xMax2 && xMax1 > xMin2 && yMin1 < yMax2 && yMax1 > yMin2);
    }
    
    // Método para verificar si dos rectángulos están juntos
    public static boolean estanJuntos(Rectangulo r1, Rectangulo r2) {
        double xMin1 = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double xMax1 = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
        double yMin1 = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        double yMax1 = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());
        
        double xMin2 = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double xMax2 = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        double yMin2 = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        double yMax2 = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        
        // Verificar si están juntos en el eje X
        boolean juntosX = (xMax1 == xMin2 || xMax2 == xMin1);
        boolean interceptanY = !(yMax1 <= yMin2 || yMax2 <= yMin1);
        
        // Verificar si están juntos en el eje Y
        boolean juntosY = (yMax1 == yMin2 || yMax2 == yMin1);
        boolean interceptanX = !(xMax1 <= xMin2 || xMax2 <= xMin1);
        
        return (juntosX && interceptanY) || (juntosY && interceptanX);
    }
    
    // Método para verificar si dos rectángulos son disjuntos
    public static boolean sonDisjuntos(Rectangulo r1, Rectangulo r2) {
        return !seSobreponen(r1, r2) && !estanJuntos(r1, r2);
    }
}
