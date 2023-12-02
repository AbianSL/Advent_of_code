BEGIN {
  FS = "\n";
  result = 0;
  
  numbers[1] = "one";
  numbers[2] = "two";
  numbers[3] = "three";
  numbers[4] = "four";
  numbers[5] = "five";
  numbers[6] = "six";
  numbers[7] = "seven";
  numbers[8] = "eight";
  numbers[9] = "nine";
}

func is_number(string) {
  return string ~ /[0-9]+/;
}

{
  converted = "";
  for (i = 1; i <= $0; i++) {
    string = substr($0, i);
    char = substr($0, i, 1);

    if (is_number(char)) {
      converted = converted "" char;
      continue;
    }

    for (j = 1; j <= 9; j++) {
      if (index(string, numbers[j]) == 1) {
        converted = converted "" j;
      }
    } 
  }
}

END {
  print(result);
}
