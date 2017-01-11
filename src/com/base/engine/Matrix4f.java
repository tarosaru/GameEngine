package com.base.engine;

public class Matrix4f {
	private float[][] m;
	
	public Matrix4f(){
		m = new float[4][4];
	}
	
	public Matrix4f initIdentity(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(i==j)
					m[i][j] = 1;
				else 
					m[i][j] = 0;
			}
		}
		return this;
	}
	
	public Matrix4f mul(Matrix4f r){
		Matrix4f res = new Matrix4f();
		
		for(int i=0; i<4;i++){
			for(int j=0;j<4;j++){
				res.set(i, j, m[i][0] * r.get(0, j)
							 +m[i][1] * r.get(1, j)
							 +m[i][2] * r.get(2, j)
							 +m[i][3] * r.get(3, j));
			}
		}
		
		return this;
	}
	
	//getters and setters
	public float get(int i, int j){
		return m[i][j];
	}
	
	public float[][] getM() {
		return m;
	}
	
	public void set(int i, int j, float value){
		m[i][j] = value;
	}

	public void setM(float[][] m) {
		this.m = m;
	}
	
	
}
