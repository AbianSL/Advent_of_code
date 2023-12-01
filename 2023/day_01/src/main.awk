BEGIN {
  FS = "\n";
  numbers = "";
}

function isnumeric(str) {
  return str ~ /[0-9]/;
}

{
  for (i = 1; i <= NF; i++) {
    test = $i;
    for (j = 1; j <= length($i); j++) {
      if (isnumeric(substr($i, j, 1))) {
        numbers += substr($i, j, 1);
        break;
      } 
    }

    for (j = length($i); j > 0; j--) {
      if (isnumeric(substr($i, j, 1))) {
        if (i == 1) {
          print(numbers);
          print(substr($i, j, 1));
        }
        numbers += substr($i, j, 1);
        break;
      } 
    }
  }
}

END {
  print numbers;
}
