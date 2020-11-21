package automatafd;

import static java.awt.geom.AffineTransform.*; 
import java.awt.*; 
import java.awt.geom.AffineTransform; 
import java.awt.geom.Arc2D;
import javax.swing.*; 


public class Dibujo {
    int nodos;
    int posiciones[][]={{}};
    
    public Dibujo(){
        
    }
    
    public static void main(String args[]) {
        
        JFrame t = new JFrame(); 
        t.add(new JComponent() { 
        private final int ARR_SIZE = 7; 
        
        void drawArrow(Graphics g1, int x1, int y1, int x2, int y2,String text) { 
            Graphics2D g = (Graphics2D) g1.create(); 
            double dx = x2 - x1, dy = y2 - y1; 
            double angle = Math.atan2(dy, dx); 
            int len = (int) Math.sqrt(dx*dx + dy*dy); 
            AffineTransform at = AffineTransform.getTranslateInstance(x1, y1); 
            at.concatenate(AffineTransform.getRotateInstance(angle)); 
            g.transform(at); 
            // Draw horizontal arrow starting in (0, 0) 
            g.drawLine(25, 0, len-25, 0); 
            g.drawString(text, len/2, 0);
            g.fillPolygon(new int[] {len-25, len-25-ARR_SIZE, len-25-ARR_SIZE, len-25}, 
            new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4); 
        } 
        public void drawCenteredCircle(Graphics g, int x, int y, int r,String text) {
            g.drawString(text, x-10, y+5);
            x = x-(r/2);
            y = y-(r/2);
            g.drawOval(x,y,r,r);
            
        }
        public void drawArrowCurve(Graphics g1, int x, int y,String text) {
            BasicStroke wideStroke =new BasicStroke();
            Graphics2D g = (Graphics2D) g1.create(); 
            g.setStroke(wideStroke);
            g.draw(new Arc2D.Double(x-15, y-60,30,40 ,300, 300,Arc2D.OPEN));
            g.fillRect(x-13, y-28, 7, 7);
            g.drawString(text, x-15, y-60);
        }

        public void drawCenteredCircleDouble(Graphics g, int x, int y, int r,String text) {
                    g.drawString(text, x-10, y+5);
                    int x1 = x-(r/2);
                    int x2 = x-((r-4)/2);
                    int y1 = y-(r/2);
                    int y2 = y-((r-4)/2);
                    g.drawOval(x1,y1,r,r);
                    g.drawOval(x2,y2,r-4,r-4);

                }
        public void paintComponent(Graphics g) {             
            //drawArrow(g, 200, 200, 300, 300,"a"); 
            drawCenteredCircle(g, 50, 200, 50,"Q0");
            drawCenteredCircle(g, 200, 100, 50,"Q1");
            drawCenteredCircle(g, 200, 350, 50,"Q2");
            drawCenteredCircle(g, 350, 100, 50,"Q3");
            drawCenteredCircle(g, 350, 300, 50,"Q4");
            drawCenteredCircleDouble(g, 500, 200, 50,"Q5");

            //drawArrowCurve(g, 200, 200,"b");           
            } 
        }); 

     t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
     t.setSize(700, 450); 
     t.setVisible(true); 
    } 
} 
