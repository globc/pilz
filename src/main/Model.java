package main;

import java.awt.Graphics;

public class Model {

	private final double[][] mesh;
	
	public static final Model CUBE = new Model ( new double[][]{
			// south (front)
			{0,0,0,  0,1,0,  1,1,0},
			{0,0,0,  1,1,0,  1,0,0},
			// top (from south)
			{0,1,0,  0,1,1,  1,1,1},
			{0,1,0,  1,1,1,  1,1,0},
			// north (from top)
			{0,1,1,  0,0,1,  1,0,1},
			{0,1,1,  1,0,1,  1,1,1},
			// bottom (from north)
			{0,0,1,  0,0,0,  1,0,0},
			{0,0,1,  1,0,0,  1,0,1},
			// west (from south)
			{0,0,1,  0,1,1,  0,1,0},
			{0,0,1,  0,1,0,  0,0,0},
			// east (from south)
			{1,0,0,  1,1,0,  1,1,1},
			{1,0,0,  1,1,1,  1,0,1}
	});
	
	public Model (/* from File */) {
		// TODO
		this.mesh = null;
	}
	
	/*
	 * Components must be of form {x1, y1, z1, x2, y2, z2, x3, y3, z3}.
	 */
	public Model (double[][] mesh) {
		this.mesh = mesh;
	}
	
	/*
	 * Translates the vertices of the triangles in this Model by deltaX along the x axis, by deltaY along
	 * the y axis and by deltaZ along the z axis.
	 */
	public Model getTranslated (int deltaX, int deltaY, int deltaZ){
		double[][] translatedMesh = new double[this.mesh.length][];
		for (int i = 0; i < this.mesh.length; i++) {
			translatedMesh[i] = new double[] {
					this.mesh[i][0] + deltaX, this.mesh[i][1] + deltaY, this.mesh[i][2] + deltaZ,
					this.mesh[i][3] + deltaX, this.mesh[i][4] + deltaY, this.mesh[i][5] + deltaZ,
					this.mesh[i][6] + deltaX, this.mesh[i][7] + deltaY, this.mesh[i][8] + deltaZ
					};
		}
		
		return new Model(translatedMesh);
	}
	
	public Model projectTo(GameScreen screen) {
		// TODO
		int ideaX = (int) (screen.getWidth() / 2.0 + (triangle[0] * aspectRatio / triangle[2]) * screen.getWidth() / 2.0);
		return null;
	}
	
	public void paint(Graphics g) {
		
	}
	
}