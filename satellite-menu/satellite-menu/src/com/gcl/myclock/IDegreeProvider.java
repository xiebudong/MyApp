package com.gcl.myclock;

/**
 * Interface for providing degrees between satellites. 
 * 
 * @author Siyamed SINIR
 *
 */
public interface IDegreeProvider {
	public float[] getDegrees(int count, float totalDegrees);
}
