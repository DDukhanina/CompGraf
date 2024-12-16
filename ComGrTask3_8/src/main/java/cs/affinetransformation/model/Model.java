package cs.affinetransformation.model;


import cs.affinetransformation.math.Vector2f;
import java.util.ArrayList;
import cs.affinetransformation.math.Vector3f;

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();
}
