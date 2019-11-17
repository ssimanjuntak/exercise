package com.sangga.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sangga.exercise.entity.Exercise2ResultEntity;


@Service
public class Exercise2FindOptimalPathDaoServiceImpl implements Exercise2FindOptimalPathDaoService {
	
	private static final int NO_PARENT = -1;
	List<Exercise2ResultEntity> exercise2Results = new ArrayList<Exercise2ResultEntity>();
	Exercise2ResultEntity exercise2Result = new Exercise2ResultEntity();
	String path = "";
	
	public List<Exercise2ResultEntity> findOptimalPath(int[][] adjacencyMatrix, int startVertex) throws Exception {
		int nVertices = adjacencyMatrix[0].length;
		int[] shortestDistances = new int[nVertices];
		boolean[] added = new boolean[nVertices];
		
		for(int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
			shortestDistances[vertexIndex] = Integer.MAX_VALUE; 
			added[vertexIndex] = false;
		}
		
		shortestDistances[startVertex] = 0;
		
		//Adding parents to avoid infinite loop
		int[] parents = new int[nVertices];
		parents[startVertex] = NO_PARENT;
		
		for(int i = 1; i < nVertices; i++) {

			int nearestVertex = -1; 
			int shortestDistance = Integer.MAX_VALUE; 
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
					nearestVertex = vertexIndex; 
					shortestDistance = shortestDistances[vertexIndex]; 
				} 
			} 

			added[nearestVertex] = true; 

			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex]; 
				
				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
					parents[vertexIndex] = nearestVertex; 
					shortestDistances[vertexIndex] = shortestDistance + edgeDistance; 
				} 
			} 
		}
		addResult(startVertex, shortestDistances, parents);
		
		return exercise2Results;
	}
	
	private void addResult(int startVertex, int[] distances, int[] parents) {
		int nVertices = distances.length; 
		
		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
			if (vertexIndex != startVertex) {
				exercise2Result = new Exercise2ResultEntity();
				
				exercise2Result.setVertex(startVertex + " -> " + vertexIndex);
				exercise2Result.setTotalWeight(distances[vertexIndex]);
				
				path = "";
				addPath(vertexIndex, parents);
				exercise2Result.setPath(path);

				exercise2Results.add(exercise2Result);
			} 
		} 
	}
	
	private void addPath(int currentVertex, int[] parents) {
		
		if (currentVertex == NO_PARENT) {
			return; 
		} 
		
		addPath(parents[currentVertex], parents); 
		path = path + (currentVertex == 0 ? "" : " -> ") + currentVertex;
	}

}
