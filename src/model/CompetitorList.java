package model;

import model.Competitor;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CompetitorList {
    private Competitor[] player;

    //Constructor for player
    public CompetitorList() {
        player = new Competitor[10];
        competitorArrayList = new ArrayList<>();
    }

    //Reads the CSV File
    public void readFromFile(String filename) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String filePath = "C:\\Users\\dg589065\\IdeaProjects\\TableTennisCompetition\\Directory\\RunCompetitor.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Check if the line has the correct number of fields
                if (data.length != 11) {
                    System.out.println("Error in line " + (index + 1) + ": Incorrect number of fields.");
                }

                try {
                    int competitorNumber = Integer.parseInt(data[0].trim());
                    String firstName = data[1].trim();
                    String middleName = data[2].trim();
                    String surname = data[3].trim();
                    String dateOfBirthString = data[4].trim();
                    Date dateOfBirth = parseDate(dateOfBirthString);
                    int competitorlevel = Integer.parseInt(data[5].trim());

                    // Check if scores are valid integers
                    for (int i = 6; i < data.length; i++) {
                        Integer.parseInt(data[i].trim());
                    }

                    int[] scores = Arrays.stream(Arrays.copyOfRange(data, 6, data.length))
                            .mapToInt(Integer::parseInt)
                            .toArray();

                    switch (competitorlevel){
                        case 1:
                            player[index] = new NoviceCompetitor(competitorNumber, firstName, middleName, surname, dateOfBirth, scores) {
                            };
                            break;
                        case 2:
                            player[index] = new AmateurCompetitor(competitorNumber, firstName, middleName, surname, dateOfBirth, scores) {
                            };
                            break;
                        case 3:
                            player[index] = new ProCompetitor(competitorNumber, firstName, middleName, surname, dateOfBirth, scores) {
                            };
                            break;
                        case 4:
                            player[index] = new ExpertCompetitor(competitorNumber, firstName, middleName, surname, dateOfBirth, scores) {
                            };
                            break;
                    }
                    //player[index] = new model.NoviceCompetitor(competitorNumber, firstName, middleName, surname, dateOfBirth, scores) {
                    //};


                }
                catch (NumberFormatException e) {
                    System.out.println("Error in line " + (index + 1) + ": Invalid numeric value.");

                }
                catch (ParseException e) {
                    System.out.println("Error in line " + (index + 1) + ": Invalid date format.");

                }

                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Date to string
    private Date parseDate(String dateString) throws Exception  {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    //Method to get player
    public Competitor[] getPlayer() {
        return player;
    }

    //Moved to the mainApp.Manager class
    //Write to File method
//    public void writeToFile(String filename) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
//            for (model.Competitor competitor : player) {
//                if (competitor != null) {
//                    writer.write(competitor.getFullDetails());
//                    writer.newLine(); // Add a newline between each competitor
//                }
//            }
//
//            // Find and write details of the competitor with the highest overall score
//            model.Competitor highestScorer = getCompetitorWithHighestScore();
//            if (highestScorer != null) {
//                writer.newLine(); // Add a separator between competitors and highest scorer
//                writer.write("model.Competitor with the Highest Overall Score:");
//                writer.newLine();
//                writer.write(highestScorer.getFullDetails());
//            }
//
//            // Write summary statistics
//            writer.newLine(); // Add a separator between highest scorer and summary statistics
//            writer.write("Summary Statistics:");
//            writer.newLine();
//            writer.write("Total of all scores: " + getTotalScore());
//            writer.newLine();
//            writer.write("Average of all scores: " + getAverageScore());
//            writer.newLine();
//            writer.write("Highest score: " + getHighestScore());
//            writer.newLine();
//            writer.write("Lowest score: " + getLowestScore());
//
//            // Write score frequency report
//            writer.newLine(); // Add a separator between summary statistics and score frequency report
//            writer.write("Score Frequency Report:");
//            writer.newLine();
//            Map<Integer, Integer> scoreFrequency = getScoreFrequency();
//            for (Map.Entry<Integer, Integer> entry : scoreFrequency.entrySet()) {
//                writer.write("Score " + entry.getKey() + ": " + entry.getValue() + " times");
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    //Moved to the mainApp.Manager class
    //Find highest Comp
//    public model.Competitor getCompetitorWithHighestScore() {
//        model.Competitor highestScorer = null;
//        double highestScore = Double.MIN_VALUE;
//
//        for (model.Competitor competitor : player) {
//            if (competitor != null) {
//                double overallScore = competitor.getOverallScore();
//                if (overallScore > highestScore) {
//                    highestScore = overallScore;
//                    highestScorer = competitor;
//                }
//            }
//        }
//
//        return highestScorer;
//    }

    //Moved to the mainApp.Manager class
    //Total Scores
//    public int getTotalScore() {
//        int totalScore = 0;
//
//        for (model.Competitor competitor : player) {
//            if (competitor != null) {
//                int[] scores = competitor.getScoreArray();
//                for (int score : scores) {
//                    totalScore += score;
//                }
//            }
//        }
//
//        return totalScore;
//    }

    //Moved to the mainApp.Manager class
    //Average Score
//    public double getAverageScore() {
//        int totalScore = getTotalScore();
//        int totalCompetitors = getNumberOfCompetitors();
//
//        // Avoid division by zero
//        return totalCompetitors > 0 ? (double) totalScore / totalCompetitors : 0;
//    }

    //Total Competitors
    private int getNumberOfCompetitors() {
        int count = 0;

        for (Competitor competitor : player) {
            if (competitor != null) {
                count++;
            }
        }

        return count;
    }

    //Moved to the mainApp.Manager class
    //Max scores
//    public int getHighestScore() {
//        int highestScore = Integer.MIN_VALUE;
//
//        for (model.Competitor competitor : player) {
//            if (competitor != null) {
//                int[] scores = competitor.getScoreArray();
//                for (int score : scores) {
//                    if (score > highestScore) {
//                        highestScore = score;
//                    }
//                }
//            }
//        }
//
//        return highestScore;
//    }

    //Moved to the mainApp.Manager class
    //Lowest Score
//    public int getLowestScore() {
//        int lowestScore = Integer.MAX_VALUE;
//
//        for (model.Competitor competitor : player) {
//            if (competitor != null) {
//                int[] scores = competitor.getScoreArray();
//                for (int score : scores) {
//                    if (score < lowestScore) {
//                        lowestScore = score;
//                    }
//                }
//            }
//        }
//
//        return lowestScore;
//    }

    //Moved to the mainApp.Manager class
    //Score Frequency  Method
//    public Map<Integer, Integer> getScoreFrequency() {
//        Map<Integer, Integer> scoreFrequency = new HashMap<>();
//
//        for (model.Competitor competitor : player) {
//            if (competitor != null) {
//                int[] scores = competitor.getScoreArray();
//                for (int score : scores) {
//                    scoreFrequency.put(score, scoreFrequency.getOrDefault(score, 0) + 1);
//                }
//            }
//        }
//
//        return scoreFrequency;
//    }

    //Search for model.Competitor and display output
    public Competitor getCompetitorByNumber(int competitorNumber) {
        for (Competitor competitor : player) {
            if (competitor != null && competitor.getCompetitorNumber() == competitorNumber) {
                return competitor;
            }
        }
        return null;
    }

    private ArrayList<Competitor> competitorArrayList;

    public void addCompetitor(Competitor competitor) {
        competitorArrayList.add(competitor);
    }

    public void saveUser(File file) {
        try {
            // user model
            Competitor competitor;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < competitorArrayList.size()) {
                competitor = competitorArrayList.get(i);
                save_data = competitor.getName().getFirstName() + ", " + competitor.getName().getMiddleName() + ", " + competitor.getName().getSurname();
                i++;
            }
            bufferedWriter.write(save_data);
            bufferedWriter.newLine();
            // prevents memory leak
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[] loadCompetitor(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // each lines to array
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

