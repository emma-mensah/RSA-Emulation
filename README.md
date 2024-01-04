# RSA Algorithm Emulator

## Overview

This Java program emulates the RSA algorithm, a widely used public-key cryptosystem. It accepts two prime numbers (p and q) from the user, calculates the public and private keys, and then encrypts and decrypts a plaintext message represented by an integer.

## Usage

1. **Key Generation:**

    - Accepts two prime numbers, p and q, from the user.
    - Calculates and displays the public and private RSA keys.

2. **Encryption:**

    - Accepts a plaintext message (an integer) from the user.
    - Encrypts the message using the public key and displays the ciphertext.

3. **Decryption:**

    - Accepts the ciphertext from the user.
    - Decrypts the ciphertext using the private key and displays the original plaintext.

## Example

A sample dialog is provided below:

```
Enter the prime numbers, p and q: 11 17
Calculating RSA values ....
Public RSA key is (3, 187)
Private RSA key is (107, 187)

Enter the plaintext message m (an integer): 5
Encrypting m...
The ciphertext c is 125

Decrypting c ....
The plaintext m is 5
```

## Notes

- The program operates from first principles without using standard libraries for RSA.
- It assumes user input from the console for prime numbers and plaintext message.
 
