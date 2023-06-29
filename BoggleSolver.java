import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BoggleSolver
{
    private HashSet<String> dict;
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
    public BoggleSolver(String dictionaryName) throws FileNotFoundException
    {
        File file = new File(dictionaryName);
        Scanner input = new Scanner(file);
        dict = new HashSet<>();
        while(input.hasNext())
        {
            dict.add(input.next());
        }
        //TODO
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable object
    public Iterable<String> getAllValidWords(BoggleBoard board)
    {
        //TODO
        HashSet<String> allWords = new HashSet<String>();
        for(int r = 0; r < board.rows(); r++)
        {
            for(int c = 0; c < board.cols(); c++)
            {
                boolean[][] used = new boolean[board.rows()][board.cols()];
                for(int i = 0; i < board.rows(); i++)
                {
                    for(int j = 0; j < board.cols(); j++)
                    {
                        used[i][j] = false;
                    }
                }
                HashSet<String> dictCopy = new HashSet<String>();
                String temp = board.getLetter(r,c) + "";
                if(board.getLetter(r, c) == 'Q')
                {
                    temp = temp + "U";
                }
                for(String w: dict)
                {
                    if(temp.equalsIgnoreCase(w.substring(0, temp.length())))
                    {
                        dictCopy.add(w);
                    }
                }
                gAVWHelper(board, r, c, temp, allWords, used, dictCopy);
            }
        }
        return allWords;
    }

    public void gAVWHelper(BoggleBoard board, int r, int c, String base, HashSet<String> words, boolean[][] used, HashSet<String> dict)
    {
        if(dict.isEmpty())
        {
            return;
        }

        if((r + 1 < board.rows()) && (c + 1 < board.cols()))
        {
            if(used[r + 1][c + 1] == false)
            {
                String baseCopy = base + "" + board.getLetter(r + 1, c + 1);
                if(board.getLetter(r + 1, c + 1) == 'Q')
                {
                    baseCopy = baseCopy + "U";
                }
                HashSet<String> dictCopy = new HashSet<String>();
                for(String w: dict)
                {
                    if((w.length() >= baseCopy.length()) && (baseCopy.equalsIgnoreCase(w.substring(0, baseCopy.length()))))
                    {
                        dictCopy.add(w);
                    }
                    if((w.equalsIgnoreCase(baseCopy)) && (w.length() > 2))
                    {
                        words.add(baseCopy);
                    }
                }
                boolean[][] usedCopy = new boolean[board.rows()][board.cols()];
                for(int i = 0; i < board.rows(); i++)
                {
                    for(int j = 0; j < board.cols(); j++)
                    {
                        usedCopy[i][j] = used[i][j];
                    }
                }
                usedCopy[r + 1][c + 1] = true;
                gAVWHelper(board, r + 1, c + 1, baseCopy, words, usedCopy, dictCopy);

            }
        }

        if((r + 1 < board.rows()))
        {
            if(used[r + 1][c] == false)
            {
                String baseCopy = base + "" + board.getLetter(r + 1, c);
                if(board.getLetter(r + 1, c) == 'Q')
                {
                    baseCopy = baseCopy + "U";
                }
                HashSet<String> dictCopy = new HashSet<String>();
                for(String w: dict)
                {
                    if((w.length() >= baseCopy.length()) && (baseCopy.equalsIgnoreCase(w.substring(0, baseCopy.length()))))
                    {
                        dictCopy.add(w);
                    }
                    if((w.equalsIgnoreCase(baseCopy)) && (w.length() > 2))
                    {
                        words.add(baseCopy);
                    }
                }
                boolean[][] usedCopy = new boolean[board.rows()][board.cols()];
                for(int i = 0; i < board.rows(); i++)
                {
                    for(int j = 0; j < board.cols(); j++)
                    {
                        usedCopy[i][j] = used[i][j];
                    }
                }
                usedCopy[r + 1][c] = true;
                gAVWHelper(board, r + 1, c, baseCopy, words, usedCopy, dictCopy);
            }
        }

        if((r + 1 < board.rows()) && (c - 1 >= 0))
        {
            if(used[r + 1][c - 1] == false)
            {
                String baseCopy = base + "" + board.getLetter(r + 1, c - 1);
                if(board.getLetter(r + 1, c - 1) == 'Q')
                {
                    baseCopy = baseCopy + "U";
                }
                HashSet<String> dictCopy = new HashSet<String>();
                for(String w: dict)
                {
                    if((w.length() >= baseCopy.length()) && (baseCopy.equalsIgnoreCase(w.substring(0, baseCopy.length()))))
                    {
                        dictCopy.add(w);
                    }
                    if((w.equalsIgnoreCase(baseCopy)) && (w.length() > 2))
                    {
                        words.add(baseCopy);
                    }
                }
                boolean[][] usedCopy = new boolean[board.rows()][board.cols()];
                for(int i = 0; i < board.rows(); i++)
                {
                    for(int j = 0; j < board.cols(); j++)
                    {
                        usedCopy[i][j] = used[i][j];
                    }
                }
                usedCopy[r + 1][c - 1] = true;
                gAVWHelper(board, r + 1, c - 1, baseCopy, words, usedCopy, dictCopy);
            }
        }

        if((c + 1 < board.cols()))
        {
            if(used[r][c + 1] == false)
            {
                String baseCopy = base + "" + board.getLetter(r, c + 1);
                if(board.getLetter(r, c + 1) == 'Q')
                {
                    baseCopy = baseCopy + "U";
                }
                HashSet<String> dictCopy = new HashSet<String>();
                for(String w: dict)
                {
                    if((w.length() >= baseCopy.length()) && (baseCopy.equalsIgnoreCase(w.substring(0, baseCopy.length()))))
                    {
                        dictCopy.add(w);
                    }
                    if((w.equalsIgnoreCase(baseCopy)) && (w.length() > 2))
                    {
                        words.add(baseCopy);
                    }
                }
                boolean[][] usedCopy = new boolean[board.rows()][board.cols()];
                for(int i = 0; i < board.rows(); i++)
                {
                    for(int j = 0; j < board.cols(); j++)
                    {
                        usedCopy[i][j] = used[i][j];
                    }
                }
                usedCopy[r ][c + 1] = true;
                gAVWHelper(board, r , c + 1, baseCopy, words, usedCopy, dictCopy);
            }
        }

        if((r - 1 >= 0) && (c + 1 < board.cols()))
        {
            if(used[r - 1][c + 1] == false)
            {
                String baseCopy = base + "" + board.getLetter(r - 1, c + 1);
                if(board.getLetter(r - 1, c + 1) == 'Q')
                {
                    baseCopy = baseCopy + "U";
                }
                HashSet<String> dictCopy = new HashSet<String>();
                for(String w: dict)
                {
                    if((w.length() >= baseCopy.length()) && (baseCopy.equalsIgnoreCase(w.substring(0, baseCopy.length()))))
                    {
                        dictCopy.add(w);
                    }
                    if((w.equalsIgnoreCase(baseCopy)) && (w.length() > 2))
                    {
                        words.add(baseCopy);
                    }
                }
                boolean[][] usedCopy = new boolean[board.rows()][board.cols()];
                for(int i = 0; i < board.rows(); i++)
                {
                    for(int j = 0; j < board.cols(); j++)
                    {
                        usedCopy[i][j] = used[i][j];
                    }
                }
                usedCopy[r - 1][c + 1] = true;
                gAVWHelper(board, r - 1, c + 1, baseCopy, words, usedCopy, dictCopy);
            }
        }

        if((r - 1 >= 0) && (c - 1 >= 0))
        {
            if(used[r - 1][c - 1] == false)
            {
                String baseCopy = base + "" + board.getLetter(r - 1, c - 1);
                if(board.getLetter(r - 1, c - 1) == 'Q')
                {
                    baseCopy = baseCopy + "U";
                }
                HashSet<String> dictCopy = new HashSet<String>();
                for(String w: dict)
                {
                    if((w.length() >= baseCopy.length()) && (baseCopy.equalsIgnoreCase(w.substring(0, baseCopy.length()))))
                    {
                        dictCopy.add(w);
                    }
                    if((w.equalsIgnoreCase(baseCopy)) && (w.length() > 2))
                    {
                        words.add(baseCopy);
                    }
                }
                boolean[][] usedCopy = new boolean[board.rows()][board.cols()];
                for(int i = 0; i < board.rows(); i++)
                {
                    for(int j = 0; j < board.cols(); j++)
                    {
                        usedCopy[i][j] = used[i][j];
                    }
                }
                usedCopy[r - 1][c - 1] = true;
                gAVWHelper(board, r - 1, c - 1, baseCopy, words, usedCopy, dictCopy);
            }

        }
        if(r - 1 >= 0)
        {
            if(used[r - 1][c] == false)
            {
                String baseCopy = base + "" + board.getLetter(r - 1, c);
                if(board.getLetter(r - 1, c) == 'Q')
                {
                    baseCopy = baseCopy + "U";
                }
                HashSet<String> dictCopy = new HashSet<String>();
                for(String w: dict)
                {
                    if((w.length() >= baseCopy.length()) && (baseCopy.equalsIgnoreCase(w.substring(0, baseCopy.length()))))
                    {
                        dictCopy.add(w);
                    }
                    if((w.equalsIgnoreCase(baseCopy)) && (w.length() > 2))
                    {
                        words.add(baseCopy);
                    }
                }
                boolean[][] usedCopy = new boolean[board.rows()][board.cols()];
                for(int i = 0; i < board.rows(); i++)
                {
                    for(int j = 0; j < board.cols(); j++)
                    {
                        usedCopy[i][j] = used[i][j];
                    }
                }
                usedCopy[r - 1][c] = true;
                gAVWHelper(board, r - 1, c, baseCopy, words, usedCopy, dictCopy);
            }
        }
        if(c - 1 >= 0)
        {
            if(used[r][c - 1] == false)
            {
                String baseCopy = base + "" + board.getLetter(r, c - 1);
                if(board.getLetter(r, c - 1) == 'Q')
                {
                    baseCopy = baseCopy + "U";
                }
                HashSet<String> dictCopy = new HashSet<String>();
                for(String w: dict)
                {
                    if((w.length() >= baseCopy.length()) && (baseCopy.equalsIgnoreCase(w.substring(0, baseCopy.length()))))
                    {
                        dictCopy.add(w);
                    }
                    if((w.equalsIgnoreCase(baseCopy)) && (w.length() > 2))
                    {
                        words.add(baseCopy);
                    }
                }
                boolean[][] usedCopy = new boolean[board.rows()][board.cols()];
                for(int i = 0; i < board.rows(); i++)
                {
                    for(int j = 0; j < board.cols(); j++)
                    {
                        usedCopy[i][j] = used[i][j];
                    }
                }
                usedCopy[r][c - 1] = true;
                gAVWHelper(board, r, c - 1, baseCopy, words, usedCopy, dictCopy);
            }
        }
        // Start with word base's last letter
        // Go to each letter next to starting letter to form base
        // Check if board piece is available
        // Check in dictionary if dict words / words base match up with current base
        // if it makes a word, add it to viable words dict
        // if bases match, recurse
        // Base case: if word base can't be found in dict
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A - Z.)
    public int scoreOf(String word)
    {
        //TODO
        if(word.length() <= 2)
        {
            return 0;
        }
        if(word.length() > 2 && word.length() < 5)
        {
            return 1;
        }
        if(word.length() == 5)
        {
            return 2;
        }
        if(word.length() == 6)
        {
            return 3;
        }
        if(word.length() == 7)
        {
            return 5;
        }
        return 11;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("WORKING");

        final String PATH   = "./";
        BoggleBoard  board  = new BoggleBoard(PATH + "board-q.txt");
        BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");

        int totalPoints = 0;

        for (String s : solver.getAllValidWords(board)) {
            System.out.println(s + ", points = " + solver.scoreOf(s));
            totalPoints += solver.scoreOf(s);
        }

        System.out.println("Score = " + totalPoints); //should print 84

        //new BoggleGame(4, 4);
    }

}

