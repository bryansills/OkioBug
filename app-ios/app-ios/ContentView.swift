import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()

	@State private var buttonTitle = "EMPTY"

	var body: some View {
        VStack(alignment: .leading) {
            Button(buttonTitle) {
                let currentDateTime = Date()
                let formatter = DateFormatter()
                formatter.timeStyle = .medium
                formatter.dateStyle = .long
                let dateString = formatter.string(from: currentDateTime)

                let filename = getDocumentsDirectory().appendingPathComponent("output.txt")

                do {
                    try dateString.write(to: filename, atomically: true, encoding: String.Encoding.utf8)
                } catch { /* WHOOPS */}

                do {
                    let fileText = try String(contentsOf: filename, encoding: .utf8)
                    buttonTitle = fileText
                }
                catch {/* error handling here */}
            }
            Text(greet)
        }
	}

	func getDocumentsDirectory() -> URL {
        let paths = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)
        return paths[0]
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
