package game.render;

import game.render.render_sub.ColoredText;
import resources.ConsoleColors;
import resources.Constants;

public class Screen {
    private int[][] displayIntensity;
    private String[][] displayColor;
    private int xSize;
    private int ySize;
    String rowBuffer = "";

    public Screen(int x, int y){
        displayIntensity = new int[x][y];
        displayColor = new String[x][y];
        xSize=x;
        ySize=y;
    }

    public void init(){
        for (int iy = 0; iy < ySize; iy++){
            for (int ix = 0; ix < xSize; ix++){
                setIntensity(ix, iy, 0);
                setColor(ix, iy, ConsoleColors.Text.BLACK);
            }
        }
    }

    private boolean filterX(int x){return 0 <= x && x <= xSize-1;}
    private boolean filterY(int y){return 0 <= y && y <= ySize-1;}

    public void setIntensity(int x, int y, int newPixel){
        if (filterX(x) && filterY(y)){
            displayIntensity[x][y] = newPixel;
        }
    }

    public void setColor(int x, int y, String newPixel){
        if (filterX(x) && filterY(y)){
            displayColor[x][y] = newPixel;
        }
    }


    public void replaceIntensity(int[][] newDisplay){
        displayIntensity = newDisplay;
    }
    
    public void replaceColor(String[][] newDisplay){
        displayColor = newDisplay;
    }


    public int getIntensity(int x, int y){
        return displayIntensity[x][y];
    }

    public String getColor(int x, int y){
        return displayColor[x][y];
    }


    public void display(){
        for (int iy = ySize-1; iy > -1; iy--){
            rowBuffer="";
            for (int ix = 0; ix < xSize; ix++){
                // The character is displayed twice so it looks more like a square
                rowBuffer = rowBuffer + ColoredText.format(Constants.Render.INTENSITY[displayIntensity[ix][iy]] + Constants.Render.INTENSITY[displayIntensity[ix][iy]],displayColor[ix][iy]);
            }
            System.out.println(rowBuffer + ConsoleColors.RESET);
        }
        rowBuffer="";
        for (int ix = 0; ix < xSize; ix++){
            rowBuffer = rowBuffer + ColoredText.format("██",ConsoleColors.Text.WHITE);
        }
        System.out.println(rowBuffer + ConsoleColors.RESET);
        clearDisplay();
    }

    public void clearDisplay(){
        for (int iy = 0; iy < ySize; iy++){
            for (int ix = 0; ix < xSize; ix++){
                setIntensity(ix, iy, 0);
                setColor(ix, iy, ConsoleColors.Text.BLACK);
            }
        }
    }
}
