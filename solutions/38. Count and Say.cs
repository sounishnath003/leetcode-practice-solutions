public class Solution 
{
  public string CountAndSay(int n) 
  {
    var result = "1";
    
    if (n == 1) return result;
    
    var i = 1;
    var countSay = 1;
    while (i < n)
    {
      var temp = result;
      result = string.Empty;
      for (var j = 0; j < temp.Length - 1; j++)
      {
        if (temp[j] == temp[j + 1])
        {
          countSay++;
        }
        else
        {
          result += countSay;
          result += temp[j];
          countSay = 1;
        }
      }
      result += countSay;
      result += temp[temp.Length - 1];
      countSay = 1;
      i++;
    }
    return result;
  }
}
