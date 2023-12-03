BEGIN {
  FS="";

  first_line = "";
  middle_line = "";
  last_line = "";
  
  result = 0;
}

{
  number = "";

  if (middle_line != "") {
    flag_found = 0;
    
    print "first_line: " first_line, "middle_line: " middle_line, "last_line: " last_line;
    for (i = 1; i <= NF; i++) {
      
      flag_pass = 0;
      char_middle = substr(middle_line, i, 1);
      char_middle_next = substr(middle_line, i + 1, 1);
      char_middle_prev = substr(middle_line, i - 1, 1);

      if (char_middle !~ /[0-9]/) {
        if (flag_found == 1) {
          result = result + number;
          number = "";
          flag_found = 0;
        }

        continue;
      }
      
      if (flag_found == 1) {
        number = number "" char_middle;
        continue;
      }

      if (char_middle_next ~ /[^0-9]/ && char_middle_next ~ /[^\.]/ || char_middle_prev ~ /[^0-9]/ && char_middle_prev ~ /[^\.]/) {
        flag_found = 1;
      }

      if (first_line != "" ) {
        char_first = substr(first_line, i, 1);
        char_diagonal_left = substr(first_line, i - 1, 1);
        char_diagonal_right = substr(first_line, i + 1, 1);
        
        if (char_first ~ /\./ || char_first ~ /[0-9]/ && char_diagonal_left ~ /\./ || char_diagonal_left ~ /[0-9]/ && char_diagonal_right ~ /\./ || char_diagonal_right ~ /[0-9]/) {
          flag_pass = 1;
        }

        if (char_first ~ /[^\.]/ && char_first ~ /[^0-9]/ || char_diagonal_left ~ /[^\.]/ && char_diagonal_left ~ /[^0-9]/ || char_diagonal_right ~ /[^\.]/ && char_diagonal_right ~ /[^0-9]/) {
          flag_found = 1;
        }
      }
      
      if (last_line != "") {
        char_last = substr(last_line, i, 1);
        char_diagonal_left = substr(last_line, i - 1, 1);
        char_diagonal_right = substr(last_line, i + 1, 1);
        
        if (char_last ~ /\./ || char_last ~ /[0-9]/ && char_diagonal_left ~ /\./ || char_diagonal_left ~ /[0-9]/ && char_diagonal_right ~ /\./ || char_diagonal_right ~ /[0-9]/) {
          flag_pass = 1;
        }

        if (char_last ~ /[^\.]/ && char_last ~ /[^0-9]/ || char_diagonal_left ~ /[^\.]/ && char_diagonal_left ~ /[^0-9]/ || char_diagonal_right ~ /[^\.]/ && char_diagonal_right ~ /[^0-9]/) {
          flag_found = 1; 
        }
      }

      if (flag_pass == 1) {
        continue;
      }

      number = number "" char_middle;
      
    }
  }

  first_line = middle_line;
  middle_line = last_line;
  last_line = $0;
}

END {
  print result;
}
