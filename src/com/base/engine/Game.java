package com.base.engine;

public class Game {
	private Mesh mesh;

	public Game(){
		mesh = new Mesh();
		Vertex[] data = new Vertex[]{ new Vertex(new Vector3f(-1,-1,0)),
									  new Vertex(new Vector3f( 0, 1,0)),
									  new Vertex(new Vector3f( 1,-1,0))};
		mesh.addVertices(data);
	}

	public void input() {
		if (Input.getKeyDown(Input.KEY_UP))
			System.out.println("pressed up!");
		if (Input.getKeyUp(Input.KEY_UP))
			System.out.println("released up!");

		if (Input.getMouseDown(1))
			System.out.println("Clicked @ (" + Input.getMousePos().getX() + ", " + Input.getMousePos().getY() + ")");
	}

	public void render() {
		mesh.draw();
	}

	public void update() {

	}
}
