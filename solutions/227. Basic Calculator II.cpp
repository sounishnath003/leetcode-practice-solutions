            }
             
            values.push(val);
             
            // right now the i points to 
            // the character next to the digit,
            // since the for loop also increases 
            // the i, we would skip one 
            //  token position; we need to 
            // decrease the value of i by 1 to
            // correct the offset.
              i--;
        }
         
        // Closing brace encountered, solve 
        // entire brace.
        else if(tokens[i] == ')')
        {
            while(!ops.empty() && ops.top() != '(')
            {
                int val2 = values.top();
                values.pop();
                 
                int val1 = values.top();
                values.pop();
                 
                char op = ops.top();
                ops.pop();
                 
                values.push(applyOp(val1, val2, op));
            }
             
            // pop opening brace.
            if(!ops.empty())
               ops.pop();
        }
         
        // Current token is an operator.
        else
        {
            // While top of 'ops' has same or greater 
            // precedence to current token, which
            // is an operator. Apply operator on top 
            // of 'ops' to top two elements in values stack.
            while(!ops.empty() && precedence(ops.top())
                                >= precedence(tokens[i])){
