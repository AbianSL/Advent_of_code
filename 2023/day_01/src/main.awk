BEGIN {
  FS = "\n";
  numbers = "";
}

function is_numeric(str) {
  return str ~ /[0-9]/;
}

function convert(str) {
  gsub(/one/, 1, str);
  gsub(/two/, 2, str);
  gsub(/three/, 3, str);
  gsub(/four/, 4, str);
  gsub(/five/, 5, str);
  gsub(/six/, 6, str);
  gsub(/seven/, 7, str);
  gsub(/eight/, 8, str);
  gsub(/nine/, 9, str);
  return str;
}

{
  for (i = 1; i <= NF; i++) {
    converted = convert($i); 

    for (j = 1; j <= length($converted); j++) {
      if (is_numeric(substr($converted, j, 1))) {
        numbers = numbers "" substr($converted, j, 1);
        break;
      }
    }

    for (j = length($converted); j > 0; j--) {
      if (is_numeric(substr($converted, j, 1))) {
        numbers = numbers "" substr($converted, j, 1);
        break;
      } 
    }
  }
}

END {
  for (i = 1; i < length(numbers); i += 2) {
    sum += substr(numbers, i, 2);
  }
  print(sum)
}
