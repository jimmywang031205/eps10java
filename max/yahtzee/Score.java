public class Score
{
    private String description;
    private int used=0;
    private int score=0;
    public Score(String name)
    {
        setDescription(name);
    }
    
    public void setDescription(String _description)
    {
        description=_description;
    }
    public String getDescription()
    {
        return description;
    }
    
    public void setUsed(int _used)
    {
        used=_used;
    }
    public int getUsed()
    {
        return used;
    }
    
    public void setScore(int _score)
    {
        score=_score;
    }
    public int getScore()
    {
        return score;
    }
}
