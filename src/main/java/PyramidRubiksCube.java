import java.util.Arrays;

enum Color{Red, Green, Blue, Yellow}

class Face{
    private Color[] tiles;
    public Face(Color[] color){
        tiles = new Color[9];
        Arrays.fill(tiles, color);

    }

    public Color[] getTiles(){
        return tiles;
    }
}
public class PyramidRubiksCube {
    private final Face[] faces;

    public PyramidRubiksCube(Face[] faces){
        this.faces = faces;
        InitializeFaces();
        InitializeEdges();
    }

    public Face[] getFaces(){
        return faces;
    }

    private void InitializeFaces() {
        Color[] color = new Color[9];
        for(int i = 0; i < faces().length; i++){
            faces[i] = new Face(color);
        }
    }

    private int[] faces() {
        return new int[0];
    }


    private void InitializeEdges() {

        int[][] adjacentFace = {

        };

        int[][] edgeIndices = {

        };
    }

    public boolean validateCube(){

        return false;
    }

}
