import SwiftUI
import shared

struct ContentView: View {
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
                
                let fileManager = OkioFileManagerFactory(absoluteFilePath: filename.absoluteString).create()

                fileManager.append(newText: dateString)
                buttonTitle = fileManager.read()
            }
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
