BEGIN {
  FS = "\n";
  numbers = "";
  result = 0;
}

function is_numeric(str) {
  return str ~ /[0-9]/;
}

function min_of_array(array) {
  position = array[1];
  
  if (position == 0) {
    min = 100;
  }

  for (i = 2; i <= length(array); i++) {
    if (array[i] == 0) {
      continue;
    }
    if (array[i] < position) {
      min = i;
      position = array[i];
    }
  }
  return min;
}

function max_of_array(array) {
  position = array[1];

  for (i = 2; i <= length(array); i++) {{
    if (array[i] > position) 
      max = i;
      position = array[i];
    }
  print("array[i]: " array[i])
  print("max: " max)
  print("i: " i)
  }
  return max;
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

  minimun = min_of_array(position_number);
  maximum = max_of_array(position_number);

  str = convert_one(minimun, str);
  str = convert_one(maximun, str);

  print("str: " str)
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
    numbers = "";
    print("converted: " converted)
    print("result: " result);
    print("\n") 
  }
}

END {
  print(result);
}
