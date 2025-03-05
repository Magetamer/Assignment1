import java.util.Arrays;

enum Color{Red, Green, Blue, Yellow}

class Face{
    private final Color[] tiles;

    public Face(Color color){
        tiles = new Color[9];
        Arrays.fill(tiles, color);

    }

    public Color[] getTiles(){
        return tiles;
    }

    public boolean isValid() {
        return tiles.length == 9;
    }
}

public class PyramidRubiksCube {
    private final Face[] faces;

    public PyramidRubiksCube(){
        faces = new Face[4];
        InitializeFaces();
        InitializeEdges();
    }

    //Create each face of tile size 9, from faces.length, pulling from the colors listed
    private void InitializeFaces() {
        Color[] color = {Color.Red, Color.Green, Color.Blue, Color.Yellow};
        for(int i = 0; i < faces.length; i++){
            faces[i] = new Face(color[i]);
        }
    }




    private void InitializeEdges() {

        //The common edges between faces
        int[][] adjacentFaces = {
                {0, 1}, {0, 2}, {0, 3},  //Face 0 adjacent to 1, 2, 3
                {1, 2}, {1, 3},          //Face 1 adjacent to 2, 3
                {2, 3}                   //Face 2 adjacent to 3
        };

        //When looking at the edges, read the tiles that make up those edges from the corresponding face
        int[][] edgeIndices = {
                {2, 6}, {0, 8},  //Face 0 to Face 1
                {5, 3}, {4, 4},  //Face 0 to Face 2
                {8, 0}, {6, 2},  //Face 0 to Face 3
                {2, 6}, {0, 8},  //Face 1 to Face 2
                {5, 3}, {4, 4},  //Face 1 to Face 3
                {2, 6}, {0, 8}   //Face 2 to Face 3
        };

    }


    public boolean validateCube(){

        // Check each face has exactly 9 tiles
        for (Face face : faces) {
            if (!face.isValid()) {
                return false;
            }
        }

        //Check that the 4 colors were placed correctly
        int[] colorCount = new int[4];

        //Checking the amount of tiles in each color
        for (Face face : faces) {
            for (Color tile : face.getTiles()) {
                colorCount[tile.ordinal()]++;
            }
        }

        //Each color should appear 9 times, if they don't then something is wrong and so return false
        for (int count : colorCount) {
            if (count != 9) {
                return false;
            }
        }

        return true;
    }

    //Prints a text representation of the pyramid describing the color of the tiles on each face
    public void printCube() {
        for (int i = 0; i < faces.length; i++) {
            System.out.println("Face " + i + ": " + Arrays.toString(faces[i].getTiles()));
        }
    }

    //Runs the code to make sure the current initialization is valid
    public static void main(String[] args) {
        PyramidRubiksCube cube = new PyramidRubiksCube();
        cube.printCube();

        System.out.println("Was cube created correctly? " + cube.validateCube());
    }
}
