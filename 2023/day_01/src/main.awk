BEGIN {
  FS = "\n";
  numbers = "";
  result = 0;
}

function is_numeric(str) {
  return str ~ /[0-9]/;
}

function min(array) {
  min = array[1];
  for (i = 2; i <= length(array); i++) {
    if (array[i] < min) {
      min = array[i];
    }
  }
  return (min, i);
}

function max(array) {
  max = array[1];
  for (i = 2; i <= length(array); i++) {
    if (array[i] > max) {
      max = array[i];
    }
  }
  return (max, i);
}

function convert_one(number, str) {
  if (number == 1) {
    gsub(/one/, "1", str);
  } else if (number == 2) {
    gsub(/two/, "2", str);
  } else if (number == 3) {
    gsub(/three/, "3", str);
  } else if (number == 4) {
    gsub(/four/, "4", str);
  } else if (number == 5) {
    gsub(/five/, "5", str);
  } else if (number == 6) {
    gsub(/six/, "6", str);
  } else if (number == 7) {
    gsub(/seven/, "7", str);
  } else if (number == 8) {
    gsub(/eight/, "8", str);
  } else if (number == 9) {
    gsub(/nine/, "9", str);
  }
  return str;
}

function convert(str) {
  position_number[1] = match(str, /one/);
  position_number[2] = match(str, /two/);
  position_number[3] = match(str, /three/);
  position_number[4] = match(str, /four/);
  position_number[5] = match(str, /five/);
  position_number[6] = match(str, /six/);
  position_number[7] = match(str, /seven/);
  position_number[8] = match(str, /eight/);
  position_number[9] = match(str, /nine/);

  minimun = min(position_number);
  maximum = max(position_number);
  
  str = convert_one(minimun[2], str);
  str = convert_one(maximum[2], str);

  return str;
}

{
  for (i = 1; i <= NF; i++) {
    converted = convert($i);

    for (j = 1; j <= length(converted); j++) {
      if (is_numeric(substr(converted, j, 1))) {
        numbers = numbers "" substr(converted, j, 1);
        break;
      }
    }
    for (j = length(converted); j > 0; j--) {
      if (is_numeric(substr(converted, j, 1))) {
        numbers = numbers "" substr(converted, j, 1);
        break;
      }
    }
    result += numbers;
    print($i);
    print(converted);
    print(numbers);
    print("result: " result);
    numbers = "";
  }
}

END {
  print(result);
}
