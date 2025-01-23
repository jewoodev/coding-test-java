package coding.test.datastructure_with.ch7;

public class FourierTree {
    static class Complex {
        double real;
        double imag;

        Complex(double real, double imag) {
            this.real = real;
            this.imag = imag;
        }

        Complex add(Complex other) {
            return new Complex(this.real + other.real, this.imag + other.imag);
        }

        Complex subtract(Complex other) {
            return new Complex(this.real - other.real, this.imag - other.imag);
        }

        Complex multiply(Complex other) {
            return new Complex(
                    this.real * other.real - this.imag * other.imag,
                    this.real * other.imag + this.imag * other.real
            );
        }
    }

    static void transformToFrequencyDomain(Complex[] data) {
        int n = data.length;
        if (n <= 1) return;

        int halfN = n / 2;
        Complex[] evenData = new Complex[halfN];
        Complex[] oddData = new Complex[halfN];

        for (int i = 0; i < halfN; i++) {
            evenData[i] = data[2 * i];
            oddData[i] = data[2 * i + 1];
        }

        transformToFrequencyDomain(evenData);
        transformToFrequencyDomain(oddData);

        for (int i = 0; i < halfN; i++) {
            double angle = -2 * Math.PI * i / n;
            Complex t = new Complex(Math.cos(angle), Math.sin(angle)).multiply(oddData[i]);
            data[i] = evenData[i].add(t);
            data[i + halfN] = evenData[i].subtract(t);
        }
    }

    public static void main(String[] args) {
        int n = 8;

        int[] timeDomainDataReal = {1, 2, 3, 4, 5, 6, 7, 8};
        Complex[] timeDomainData = new Complex[n];
        for (int i = 0; i < n; i++) {
            timeDomainData[i] = new Complex(timeDomainDataReal[i], 0);
        }

        transformToFrequencyDomain(timeDomainData);

        System.out.println("Frequency Domain Data:");
        for (Complex c : timeDomainData) {
            System.out.printf("%.6f + %.6fi%n", c.real, c.imag);
        }
    }
}
