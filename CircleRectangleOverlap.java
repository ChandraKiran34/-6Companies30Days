class CircleRectangleOverlap {
    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        int xc = Math.max(x1, Math.min(xCenter, x2));
        int yc = Math.max(y1, Math.min(yCenter, y2));
        int dx = xCenter - xc;
        int dy = yCenter - yc;
        return (dx * dx) + (dy * dy) <= (radius * radius);
        
    }
    public static void main(String[] args) {
        System.out.println(checkOverlap(2, 2, 2, 3, 1, 5, 3));
    }
}