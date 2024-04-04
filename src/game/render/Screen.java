package game.render;

import game.render.render_sub.ColoredText;
import resources.ConsoleColors;
import static resources.Constants.Render.*;

public class Screen {
    private int[][] displayIntensity;
    private String[][] displayColor;
    private int xSize;
    private int ySize;
    String rowBuffer = "";
    String brailleChar = "";

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
        return (!filterX(x) || !filterY(y)) ? 0 : displayIntensity[x][y];
    }

    public int getIntensityOn(int x, int y){
        return (!filterX(x) || !filterY(y)) ? 0 : ((displayIntensity[x][y]) >= 5 ? 1 : 0);
    }

    public String getColor(int x, int y){
        return (!filterX(x) || !filterY(y)) ? ConsoleColors.Text.BLACK : displayColor[x][y];
    }

    /**
     * Runs the display printer
     */
    public void display(){
        if (LOW_DENSITY_DETAIL){
            // Use two character per pixel (██ = 1 pixel) (Low Detail)
            for (int iy = ySize-1; iy > -1; iy--){
                rowBuffer="";
                for (int ix = 0; ix < xSize; ix++){
                    // The character is displayed twice so it looks more like a square
                    rowBuffer = rowBuffer + ColoredText.format(INTENSITY[displayIntensity[ix][iy]] + INTENSITY[displayIntensity[ix][iy]],displayColor[ix][iy]);
                }
                System.out.println(rowBuffer + ConsoleColors.RESET);
            }
            rowBuffer="";
            for (int ix = 0; ix < xSize; ix++){
                rowBuffer = rowBuffer + ColoredText.format("██",ConsoleColors.Text.WHITE);
            }
            System.out.println(rowBuffer + ConsoleColors.RESET);
            clearDisplay();
        } else {
            // Use one character per six pixels (⠿ = 6 pixels) (High Density)
            for (int iy = (int) Math.ceil(ySize/3)-1; iy > -1; iy--){
                rowBuffer="";
                for (int ix = 0; ix < Math.ceil(xSize/2); ix++){
                    /*
                     * Braille Characters:
                     *  Dot changes every:
                     *  |  1 |  8 |
                     *  |  2 | 16 |
                     *  |  4 | 32 |
                     */
                    brailleChar = BRAILLE[
                        (getIntensityOn(ix*2  , iy*3  )*1)
                       +(getIntensityOn(ix*2  , iy*3+1)*2)
                       +(getIntensityOn(ix*2  , iy*3+2)*4)
                       +(getIntensityOn(ix*2+1, iy*3  )*8)
                       +(getIntensityOn(ix*2+1, iy*3+1)*16)
                       +(getIntensityOn(ix*2+1, iy*3+2)*32)
                    ];
                    rowBuffer = rowBuffer + ColoredText.format(brailleChar, displayColor[ix*2][iy*3]);
                }
                System.out.println(rowBuffer + ConsoleColors.RESET);
            }
            rowBuffer="";
            for (int ix = 0; ix < xSize; ix++){
                rowBuffer = rowBuffer + ColoredText.format(BRAILLE[63],ConsoleColors.Text.WHITE);
            }
            System.out.println(rowBuffer + ConsoleColors.RESET);

        }
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
