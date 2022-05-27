package main;

import java.awt.Graphics;

// TODO Model class: Textures, Materials, Transparency

public class Mesh { 
	
	Triangle[] tris;
	
	
	Mesh(Triangle[] triangles){
		this.tris = triangles;
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
	
	public Mesh copy() {
		Triangle[] triCopy = new Triangle[tris.length];
		for (int i = 0; i < tris.length; i++) {
			triCopy[i] = new Triangle(
					tris[i].p[0].x, tris[i].p[0].y, tris[i].p[0].z,
					tris[i].p[1].x, tris[i].p[1].y, tris[i].p[1].z,
					tris[i].p[2].x, tris[i].p[2].y, tris[i].p[2].z);
		}
		
		return new Mesh(triCopy);
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

	public void translate(double deltaX, double deltaY, double deltaZ) {
		p[0].x += deltaX;
		p[0].y += deltaY;
		p[0].z += deltaZ;
		p[1].x += deltaX;
		p[1].y += deltaY;
		p[1].z += deltaZ;
		p[2].x += deltaX;
		p[2].y += deltaY;
		p[2].z += deltaZ;
	}

	public void project(double centerX, double centerY) {
		p[0].project(centerX, centerY);
		p[1].project(centerX, centerY);
		p[2].project(centerX, centerY);
	}
	
	public void paint(Graphics g) {
		g.drawPolygon(
				new int[] {(int) p[0].x, (int) p[1].x, (int) p[2].x},
				new int[] {(int) p[0].y, (int) p[1].y, (int) p[2].y},
				3);
	}
	
	public Vec3d getNormal() {
		return null;
	}
	
}

class Vec3d {
	
	public double x, y, z;
	
	Vec3d(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void project(double centerX, double centerY) {
		double aspectRatio = centerY / centerX;
		double divZ = this.z == 0 ? 1 : this.z;

		x = centerX + centerX * (x * aspectRatio / divZ);
		y = centerY + centerY * (y / divZ);
		// z = ...
	}
	
	
	
}
