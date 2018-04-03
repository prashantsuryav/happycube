package com.threesixty.cube;

import java.io.IOException;
import java.nio.file.Files;

import com.threesixty.cube.model.CubePieces;

import static com.threesixty.cube.utils.CubeUtils.createCubePieces;
import static com.threesixty.cube.utils.CubeUtils.createUnfoldedVersion;
import static com.threesixty.cube.utils.CubeUtils.getInputResourceAsStream;
import static com.threesixty.cube.utils.CubeUtils.getValidCombination;
import static java.nio.file.Paths.get;

/**
 * Happy Cube Solver!
 */
public class HappyCubeSolver {

    private static final String BLUE_CUBE_INPUT = "blue-cube.txt";
    private static final String YELLOW_CUBE_INPUT = "yellow-cube.txt";
    private static final String RED_CUBE_INPUT = "red-cube.txt";
    private static final String PURPLE_CUBE_INPUT = "purple-cube.txt";

    public static void main(String[] args) throws IOException {

        getSolution(BLUE_CUBE_INPUT, "blue-cube-solved.txt");
        getSolution(YELLOW_CUBE_INPUT, "yellow-cube-solved.txt");
        getSolution(RED_CUBE_INPUT, "red-cube-solved.txt");
        getSolution(PURPLE_CUBE_INPUT, "purple-cube-solved.txt");

    }

    private static void getSolution(String filename, String solutionFilename) throws IOException {
        final String cubeString = getInputResourceAsStream(filename);
        final CubePieces cubePieces = createCubePieces(cubeString);
        final CubePieces validCubePiece = getValidCombination(cubePieces);
        Files.write(get(solutionFilename), createUnfoldedVersion(validCubePiece).getBytes());
    }

}