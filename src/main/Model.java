package main;

public class Model {
	
	private Mesh mesh;
	// TODO Textures, Materials, Transparency?
	
	Model (/* load from File */){
		// TODO
	}
	
}

class Mesh {
	
	private Triangle[] tris;
	
	
	Mesh(Triangle[] triangles){
		this.tris = triangles;
	}
	
	
	
	public Mesh translate(double deltaX, double deltaY, double deltaZ) {
		Triangle[] meshOut = new Triangle[tris.length];
		for (int i = 0; i < tris.length; i++) {
			meshOut[i] = new Triangle(
					tris[i].p[0].x + deltaX, tris[i].p[0].y + deltaY, tris[i].p[0].z + deltaZ,
					tris[i].p[1].x + deltaX, tris[i].p[1].y + deltaY, tris[i].p[1].z + deltaZ,
					tris[i].p[2].x + deltaX, tris[i].p[2].y + deltaY, tris[i].p[2].z + deltaZ
					);
		}
		return new Mesh(meshOut);
		
	}
	
	public static Mesh getDefaultCube() {
		return new Mesh( new Triangle[]{
				//south (front)
				new Triangle(0,0,0,  0,1,0,  1,1,0),
				new Triangle(0,0,0,  1,1,0,  1,0,0),
				//top (from south)
				new Triangle(0,1,0,  0,1,1,  1,1,1),
				new Triangle(0,1,0,  1,1,1,  1,1,0),
				//north (from top)
				new Triangle(0,1,1,  0,0,1,  1,0,1),
				new Triangle(0,1,1,  1,0,1,  1,1,1),
				//bottom (from north)
				new Triangle(0,0,1,  0,0,0,  1,0,0),
				new Triangle(0,0,1,  1,0,0,  1,0,1),
				//west (from south)
				new Triangle(0,0,1,  0,1,1,  0,1,0),
				new Triangle(0,0,1,  0,1,0,  0,0,0),
				//east (from south)
				new Triangle(1,0,0,  1,1,0,  1,1,1),
				new Triangle(1,0,0,  1,1,1,  1,0,1)
		});
	}
	
}

class Triangle {
	
	Vec3d[] p;
	
	Triangle(double x0, double y0, double z0, double x1, double y1, double z1, double x2, double y2, double z2) {
		this(new Vec3d(x0, y0, z0), new Vec3d(x1, y1, z1), new Vec3d(x2, y2, z2));

		
	}
	
	Triangle(Vec3d p0, Vec3d p1, Vec3d p2){
		p = new Vec3d[] {p0, p1, p2};
	}
	
	// TODO getNormal();
	
}

class Vec3d {
	
	public double x, y, z;
	
	Vec3d(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static Vec3d add(Vec3d v0, Vec3d v1) {
		return new Vec3d(v0.x + v1.x, v0.y + v1.y, v0.z + v1.z);
	}
	
}
